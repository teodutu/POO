package utils;

import enums.IllnessType;
import enums.State;

import java.util.EnumSet;

/**
 * Contine detalii despre modul de functionare al unui doctor: efectele consultatiilor, operatiilor,
 * bolile tratabile si mesajele care trebuie scrise in output.
 */
public class DoctorType {
    // in ordine: C1, C2, T, din enunt
    private float consultationEffect, operationEffect;
    static final int TREATMENT = 22;
    private EnumSet<IllnessType> treatableIllnesses;
    private State homeState, hospitalisedState, operateState;

    public DoctorType(float consultation, float operation, State home, State hospitalised,
                      State operate, EnumSet<IllnessType> illnessTypes) {
        consultationEffect = consultation;
        operationEffect = operation;
        treatableIllnesses = illnessTypes;
        homeState = home;
        hospitalisedState = hospitalised;
        operateState = operate;
    }

    public final State getHomeState() {
        return homeState;
    }

    public final State getHospitalisedState() {
        return hospitalisedState;
    }

    public final State getOperateState() {
        return operateState;
    }

    public final float getConsultationEffect() {
        return consultationEffect;
    }

    public final float getOperationEffect() {
        return operationEffect;
    }

    public final EnumSet<IllnessType> getTreatableIllnesses() {
        return treatableIllnesses;
    }
}
