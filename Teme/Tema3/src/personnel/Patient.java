package personnel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import enums.IllnessType;
import enums.InvestigationResult;
import enums.State;
import enums.Urgency;
import factories.PatientIllnessFactory;
import utils.PatientState;
import utils.UrgencyEstimator;

/**
 * Implementeaza si defineste comportamentul unui pacient al spitalului.
 * Se ignora la citire campurile inutile in algoritmul de tratare a pacientilor.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {
    private int time, roundsOfTreatment;
    private String name;
    private PatientState state;
    private Urgency urgency;
    private IllnessType illnessType;
    private InvestigationResult investigationResult;
    private State treatmentState;

    public Patient() {
        investigationResult = InvestigationResult.NOT_DIAGNOSED;
    }

    /**
     * Se determina urgenta necesitatiii tratarii pacientului.
     */
    public void estimateUrgency() {
        urgency = UrgencyEstimator.getInstance().estimateUrgency(illnessType, state.getSeverity());
    }

    /**
     * Simuleaza administrarea tratamentului de catre o asistenta.
     *
     * @param treatment tratamentul prescris de medic
     */
    public boolean applyTreatment(int treatment) {
        state.setSeverity(state.getSeverity() - treatment);
        --roundsOfTreatment;

        return roundsOfTreatment == 0 || state.getSeverity() <= 0;
    }

    /**
     * Simuleaza operarea pacientului de catre un doctor.
     *
     * @param operationEffect factorul de ameliorare a severitatii ca rezultat al operatiei
     */
    public void applyOperation(float operationEffect) {
        int currSeverity = state.getSeverity();
        state.setSeverity(currSeverity - Math.round(currSeverity * operationEffect));
    }

    final void setRoundsOfTreatment(int roundsOfTreatment) {
        this.roundsOfTreatment = roundsOfTreatment;
    }

    public final void setInvestigationResult(InvestigationResult investigationResult) {
        this.investigationResult = investigationResult;
    }

    public final InvestigationResult getInvestigationResult() {
        return investigationResult;
    }

    public final State getTreatmentState() {
        return treatmentState;
    }

    public final void setTreatmentState(State treatmentState) {
        this.treatmentState = treatmentState;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getTime() {
        return time;
    }

    public final void setTime(int time) {
        this.time = time;
    }

    public final PatientState getState() {
        return state;
    }

    public final void setState(PatientState state) {
        this.state = state;
        illnessType = PatientIllnessFactory.getInstance().getIllnessType(state.getIllnessName());
    }

    public final Urgency getUrgency() {
        return urgency;
    }

    public final IllnessType getIllnessType() {
        return illnessType;
    }

    public final int getRoundsOfTreatment() {
        return roundsOfTreatment;
    }
}
