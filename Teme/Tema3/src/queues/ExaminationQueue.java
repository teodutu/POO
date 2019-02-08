package queues;

import enums.State;
import personnel.Patient;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Implementeaza functionarea cozii de examinare a pacientilor.
 */
public class ExaminationQueue {
    private PriorityQueue<Patient> queue;

    public ExaminationQueue() {
        queue = new PriorityQueue<>(1,
                Comparator.comparing(Patient::getUrgency).reversed()
                          .thenComparingInt(patient -> patient.getState().getSeverity())
                          .thenComparing(Patient::getName).reversed());
    }

    /**
     * Adauga un nou pacient in coada de examinare, actualizandu-i si starea.
     *
     * @param patient pacientul ce trebuie adaugat
     */
    public void addPatient(Patient patient) {
        patient.setTreatmentState(State.EXAMINATIONSQUEUE);
        queue.add(patient);
    }

    /**
     * Adauga o lista de pacienti in coada de examinare, actualizandu-le starile.
     *
     * @param patients lista de pacienti ce trebuie adaugati
     */
    public void addPatientsList(List<Patient> patients) {
        for (Patient currPatient : patients) {
            currPatient.setTreatmentState(State.EXAMINATIONSQUEUE);
        }

        queue.addAll(patients);
    }

    /**
     * Scoate si returneaza ptimul pacient din coada.
     *
     * @return primul pacient
     */
    public Patient removePatient() {
        return queue.poll();
    }

    public final boolean isEmpty() {
        return queue.isEmpty();
    }
}
