package personnel;

import enums.State;
import factories.DoctorNameFactory;
import factories.DoctorTypeFactory;
import utils.DoctorType;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Observer;
import java.util.TreeSet;
import java.util.Observable;

/**
 * Simuleaza actiunile unui doctor.
 */
public class Doctor implements Observer {
    private final int minRounds = 3;
    private String specialist;
    private int maxForTreatment;
    private boolean isSurgeon;
    private DoctorType doctorType;

    // retine toti pacientii doctorului sortati alfabetic dupa nume
    private TreeSet<Patient> internedPatients;

    public Doctor() {
        internedPatients = new TreeSet<>(Comparator.comparing(Patient::getName));
    }

    /**
     * Doctorul va examina un pacient respectand indicatia ERTechnician-ului si returneaza coduri
     * ce vor fi utilizate pentru urmatoarele actiuni asupra pacientului.
     *
     * @param patient pacientul examinat
     * @return        0 daca nu trebuie facut nimic
     *                1 daca pacientul trebuie adaugat in InvestigationsQueue
     *                2 daca pacientul trebuie internat
     *                Integer.MAX_VALUE daca starea pacientului este necunoscuta
     */
    public int examinePatient(Patient patient) {
        switch (patient.getInvestigationResult()) {
            case NOT_DIAGNOSED:
                if (patient.getState().getSeverity() <= maxForTreatment) {
                    patient.setTreatmentState(doctorType.getHomeState());
                    return 0;  // pacientul este trimis acasa
                }

                return 1;  // pacientul merge in InvestigationsQueu
            case HOSPITALIZE:
                internedPatients.add(patient);
                patient.setTreatmentState(doctorType.getHospitalisedState());
                patient.setRoundsOfTreatment(Math.max(Math.round(patient.getState().getSeverity()
                        * doctorType.getConsultationEffect()), minRounds));

                return 2;  // pacientul e internat
            case OPERATE:
                patient.setTreatmentState(doctorType.getOperateState());

                if (isSurgeon) {
                    internedPatients.add(patient);
                    patient.applyOperation(doctorType.getOperationEffect());
                    patient.setRoundsOfTreatment(Math.max(Math.round(patient.getState()
                            .getSeverity() * doctorType.getConsultationEffect()), minRounds));
                }

                return 2;  // pacientul e operat si apoi internat
            case TREATMENT:
                patient.setTreatmentState(doctorType.getHomeState());
                return 0;  // pacientul este trimis acasa sa se trateze
            default:
                return Integer.MAX_VALUE;
        }
    }

    /**
     * Se verififca toata lista de pacienti si se analizeaza starea acestora, afisand mesajele
     * corespunzatoare.
     */
    @Override
    public void update(Observable observable, Object o) {
        for (Iterator<Patient> iterator = internedPatients.iterator(); iterator.hasNext();) {
            Patient currPatient = iterator.next();

            // daca tratamentul s-a terminat, pacientul este externat
            // de asemenea, se afiseaza deciziad medicului
            if (currPatient.getTreatmentState() == State.HOME_DONE_TREATMENT) {
                System.out.println(specialist + " sent "  + currPatient.getName() + " home");
                iterator.remove();
            } else {
                System.out.println(specialist + " says that "  + currPatient.getName()
                        + " should remain in hospital");
            }
        }
    }

    /**
     * Pornind de la specializarea doctorului sub forma de string, aceasta e prelucrata si se obtin
     * parametrii cu care dctorul va opera, consulta si trata.
     *
     * @param type stringul in input ce contine specializarea
     */
    public final void setType(String type) {
        specialist = DoctorNameFactory.getInstance().makeName(type);
        doctorType = DoctorTypeFactory.getInstance().getDoctorType(type);
    }

    public final void setIsSurgeon(String isSurgeon) {
        if (isSurgeon.equals("true") || specialist.equals("General Surgeon")) {
            this.isSurgeon = true;
        }
    }

    public final boolean isSurgeon() {
        return isSurgeon;
    }

    public final int getMaxForTreatment() {
        return maxForTreatment;
    }

    public final void setMaxForTreatment(int maxForTreatment) {
        this.maxForTreatment = maxForTreatment;
    }

    public final DoctorType getDoctorType() {
        return doctorType;
    }
}
