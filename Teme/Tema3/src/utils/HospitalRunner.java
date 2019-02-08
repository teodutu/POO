package utils;

import enums.InvestigationResult;
import enums.State;
import personnel.Doctor;
import personnel.Patient;
import queues.ExaminationQueue;
import queues.InvestigationsQueue;
import queues.TriageQueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Simuleaza functionarea camerei de garda a unui spital.
 */
public class HospitalRunner extends Observable {
    private final int c1 = 75, c2 = 40;
    private int simulationLength, nurses, investigators;
    private List<Patient> incomingPatients;
    private TriageQueue triageQueue;
    private InvestigationsQueue investigationsQueue;
    private ExaminationQueue examinationQueue;

    // o lista ce contine toti doctorii si care va suferi modificarile necesare in momentul in care
    // un doctor examineaza un pacient
    private LinkedList<Doctor> doctorsQueue;

    // retine  pacientii internati in ordinea alfabetica a numelor acestora
    private TreeSet<Patient> internedPatients;

    // mentine toti pacientii care au ajuns pana acum la spital, in ordine alfabetica
    // este in acelasi timp o lista de observatori
    private TreeSet<Patient> processedPatients;

    public HospitalRunner() {
        triageQueue = new TriageQueue();
        investigationsQueue = new InvestigationsQueue();
        examinationQueue = new ExaminationQueue();
        internedPatients = new TreeSet<>(Comparator.comparing(Patient::getName));
        processedPatients = new TreeSet<>(Comparator.comparing(Patient::getName));
        doctorsQueue = new LinkedList<>();
    }

    /**
     * Asistentele aplica fiecarui pacient tratamentul descris de un medic, iar fiecare doctor isi
     * verifica pacientii si ofera un verdict.
     */
    public void applyTreatment() {
        int i = -1;

        System.out.println("\n~~~~ Nurses treat patients ~~~~");

        // asistentele trec pe rand pe la pacienti si le reduc severitatea bolii prin administrarea
        // tratamentului
        for (Patient currPatient : internedPatients) {
            // daca in urma tratamentului, pacientul s-a insanatosit, se updateaza starea acestuia
            if (currPatient.applyTreatment(DoctorType.TREATMENT)) {
                currPatient.setTreatmentState(State.HOME_DONE_TREATMENT);
            }

            System.out.print(("Nurse " + (++i % nurses) + " treated " + currPatient.getName()
                    + " and patient has " + currPatient.getRoundsOfTreatment()
                    + " more round"));

            if (currPatient.getRoundsOfTreatment() != 1) {
                System.out.print("s");
            }
            System.out.println();
        }

        System.out.println("\n~~~~ Doctors check their hospitalized patients and give verdicts "
                + "~~~~");

        // fiecare doctor isi va verifica pacientii
        setChanged();
        notifyObservers();
        internedPatients.removeIf(patient ->
                patient.getTreatmentState() == State.HOME_DONE_TREATMENT);
    }

    /**
     * Se preiau pacientii veniti si se adauga in TriageQueue.
     *
     * @param roundNumber numarul rundei curente
     */
    public void triagePatients(int roundNumber) {
        // toti pacientii veniti in runda curenta sunt adaugati in TriageQueue
        for (Iterator<Patient> iterator = incomingPatients.iterator(); iterator.hasNext();) {
            Patient currPatient = iterator.next();

            if (currPatient.getTime() == roundNumber) {
                triageQueue.addPatient(currPatient);
                currPatient.setTreatmentState(State.TRIAGEQUEUE);
                processedPatients.add(currPatient);
                iterator.remove();
            }
        }

        // se triaza pacientii din TriageQueue, iar cele mai urgente cazuri se adauga in
        // ExaminationQueue
        examinationQueue.addPatientsList(triageQueue.doTriage(nurses));
    }

    /**
     * Se ruleaza procesul corespunzator etapei de examinare.
     */
    public void examinePatients() {
        while (!examinationQueue.isEmpty()) {
            Patient currPatient = examinationQueue.removePatient();
            Doctor currDoctor = getFirstDoctor(currPatient);

            // daca este nevoie de un chirurg, dar acesta nu este disponibil
            if (currDoctor == null) {
                currPatient.setTreatmentState(State.OTHERHOSPITAL);
            } else {
                // se muta doctorul curant al pacientului curent la capatul listei
                doctorsQueue.remove(currDoctor);
                doctorsQueue.add(currDoctor);

                // din ExaminationQueue pacientul poate merge in 3 directii: internare, in
                // InvestigationsQueue sau acasa
                switch (currDoctor.examinePatient(currPatient)) {
                    case 1:
                        investigationsQueue.addPatient(currPatient);
                        break;
                    case 2:
                        internedPatients.add(currPatient);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    /**
     * Se ruleaza etapa de investigare.
     */
    public void investigatePatients() {
        for (int i = 0; i < investigators && !investigationsQueue.isEmpty(); ++i) {
            Patient currPatient = investigationsQueue.removePatient();
            int currPatientSeverity = currPatient.getState().getSeverity();

            // ERTechnician decide ce actiune trebuie luata in ceea ce priveste pacientul curent
            if (currPatientSeverity > c1) {
                currPatient.setInvestigationResult(InvestigationResult.OPERATE);
            } else if (currPatientSeverity > c2) {
                currPatient.setInvestigationResult(InvestigationResult.HOSPITALIZE);
            } else {
                currPatient.setInvestigationResult(InvestigationResult.TREATMENT);
            }

            examinationQueue.addPatient(currPatient);
        }
    }

    /**
     * Pacientii sunt luati in ordine alfabetica si li se afiseaza starea.
     */
    public void printMessages() {
        for (Patient currPatient : processedPatients) {
            System.out.println(currPatient.getName() + " is "
                    + currPatient.getTreatmentState().getValue());
        }
    }

    /**
     * Se gaseste doctorul curant al pacientului dat.
     *
     * @param patient pacientul al carui doctor se cauta
     * @return        doctorul acestui pacient
     */
    private Doctor getFirstDoctor(Patient patient) {
        for (Doctor currDoctor : doctorsQueue) {
            if (currDoctor.getDoctorType().getTreatableIllnesses().contains(
                    patient.getIllnessType())) {
                if (patient.getInvestigationResult() == InvestigationResult.OPERATE
                        && currDoctor.isSurgeon()) {
                    return currDoctor;  // daca este nevoie de un chirurg
                } else if (patient.getInvestigationResult() != InvestigationResult.OPERATE) {
                    return currDoctor;  // daca nu este necesar un chirurg
                }
            }
        }

        return null;
    }

    public final int getSimulationLength() {
        return simulationLength;
    }

    public final void setSimulationLength(int simulationLength) {
        this.simulationLength = simulationLength;
    }

    public final void setNurses(int nurses) {
        this.nurses = nurses;
    }

    public final void setInvestigators(int investigators) {
        this.investigators = investigators;
    }

    /**
     * Creeaza coada de doctori si ii inregistreaza ca observatori.
     *
     * @param doctors lista de doctori citita din fisierul de input
     */
    public final void setDoctors(List<Doctor> doctors) {
        doctorsQueue.addAll(doctors);

        // se inregistreaza doctorii ca observatori, in ordinea citirii din fisier
        for (ListIterator<Doctor> iterator = doctors.listIterator(doctors.size());
             iterator.hasPrevious();) {
             addObserver(iterator.previous());
        }
    }

    public final void setIncomingPatients(List<Patient> incomingPatients) {
        this.incomingPatients = incomingPatients;
    }
}
