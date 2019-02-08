package queues;

import enums.State;
import personnel.Patient;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implementeaza functionarea cozii de investigatii a pacientilor.
 */
public class InvestigationsQueue {
    private PriorityQueue<Patient> queue;

    public InvestigationsQueue() {
        queue = new PriorityQueue<>(1,
                Comparator.comparing(Patient::getUrgency).reversed()
                          .thenComparingInt(patient -> patient.getState().getSeverity())
                          .thenComparing(Patient::getName).reversed());
    }

    /**
     * Adauga un nou pacient in coada de investigatii, actualizandu-i si starea.
     *
     * @param patient pacientul ce trebuie adaugat
     */
    public void addPatient(Patient patient) {
        queue.add(patient);
        patient.setTreatmentState(State.INVESTIGATIONSQUEUE);
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
