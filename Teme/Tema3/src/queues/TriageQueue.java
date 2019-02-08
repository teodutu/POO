package queues;

import enums.State;
import personnel.Patient;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Implementeaza functionarea cozii de triaj a pacientilor.
 */
public class TriageQueue {
    private PriorityQueue<Patient> queue;

    public TriageQueue() {
        queue = new PriorityQueue<>(1,
                Comparator.comparingInt((Patient p) -> p.getState().getSeverity()).reversed());
    }

    /**
     * Asistentele efectueaza triajul propriu-zis al pacientilor, determinand urgenta afectiunilor
     * celor mai severe cazuri si actualizandu-le starea.
     *
     * @param numNurses numarul de asistente
     * @return          lista cu pacientii ce merg in ExaminationQueue
     */
    public ArrayList<Patient> doTriage(int numNurses) {
        ArrayList<Patient> movedToExamination = new ArrayList<>();

        for (int i = 0; i < numNurses && !queue.isEmpty(); ++i) {
            Patient currPatient = queue.poll();

            currPatient.estimateUrgency();
            movedToExamination.add(currPatient);
            currPatient.setTreatmentState(State.EXAMINATIONSQUEUE);
        }

        return movedToExamination;
    }

    /**
     * Se adauga un pacient in coada si i se modifica si starea.
     *
     * @param patient pacientul nou adaugat
     */
    public void addPatient(Patient patient) {
        patient.setTreatmentState(State.TRIAGEQUEUE);
        queue.add(patient);
    }
}
