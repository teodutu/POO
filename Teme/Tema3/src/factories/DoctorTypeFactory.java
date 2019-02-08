package factories;

import enums.State;
import utils.DoctorType;
import enums.IllnessType;

import java.util.EnumSet;

/**
 * Ajuta la crearea campurilor necesare clasei "Doctor", plecand de inputul din fisierul JSON.
 */
public class DoctorTypeFactory {
    private static final float CARDIO_CONSULTATION = 0.4f, CARDIO_OPERATION = 0.1f;
    private static final float ER_CONSULTATION = 0.1f, ER_OPERATION = 0.3f;
    private static final float GASTRO_CONSULTATION = 0.5f, GASTRO_OPERATION = 0;
    private static final float SURGEON_CONSULTATION = 0.2f, SURGEON_OPERATION = 0.2f;
    private static final float INTERN_CONSULTATION = 0.01f, INTERN_OPERATION = 0;
    private static final float NEURO_CONSULTATION = 0.5f, NEURO_OPERATION = 0.1f;
    private static DoctorTypeFactory doctorTypeFactory;

    /**
     * Creeaza un tip de doctor in functie de numele specializarii acestuia.
     *
     * @param doctorType string ce reprezinta specializarea
     * @return           tipul de doctor aferent acestei specializari
     */
    public DoctorType getDoctorType(String doctorType) {
        switch (doctorType) {
            case "CARDIOLOGIST":
                return new DoctorType(CARDIO_CONSULTATION, CARDIO_OPERATION,
                        State.HOME_CARDIO, State.HOSPITALIZED_CARDIO, State.OPERATED_CARDIO,
                        EnumSet.of(IllnessType.HEART_ATTACK, IllnessType.HEART_DISEASE));
            case "ER_PHYSICIAN":
                return new DoctorType(ER_CONSULTATION, ER_OPERATION, State.HOME_ERPHYSICIAN,
                        State.HOSPITALIZED_ERPHYSICIAN, State.OPERATED_ERPHYSICIAN,
                        EnumSet.of(IllnessType.ALLERGIC_REACTION, IllnessType.BROKEN_BONES,
                                IllnessType.BURNS, IllnessType.CAR_ACCIDENT, IllnessType.CUTS,
                                IllnessType.HIGH_FEVER, IllnessType.SPORT_INJURIES));
            case "GASTROENTEROLOGIST":
                return new DoctorType(GASTRO_CONSULTATION, GASTRO_OPERATION, State.HOME_GASTRO,
                        State.HOSPITALIZED_GASTRO, State.OTHERHOSPITAL,
                        EnumSet.of(IllnessType.ABDOMINAL_PAIN, IllnessType.ALLERGIC_REACTION,
                                IllnessType.FOOD_POISONING));
            case "GENERAL_SURGEON":
                return new DoctorType(SURGEON_CONSULTATION, SURGEON_OPERATION, State.HOME_SURGEON,
                        State.HOSPITALIZED_SURGEON, State.OPERATED_SURGEON,
                        EnumSet.of(IllnessType.ABDOMINAL_PAIN, IllnessType.BURNS, IllnessType.CUTS,
                                IllnessType.CAR_ACCIDENT, IllnessType.SPORT_INJURIES));
            case "INTERNIST":
                return new DoctorType(INTERN_CONSULTATION, INTERN_OPERATION,
                        State.HOME_INTERNIST, State.HOSPITALIZED_INTERNIST, State.OTHERHOSPITAL,
                        EnumSet.of(IllnessType.ABDOMINAL_PAIN, IllnessType.ALLERGIC_REACTION,
                                IllnessType.FOOD_POISONING, IllnessType.HEART_DISEASE,
                                IllnessType.HIGH_FEVER, IllnessType.PNEUMONIA));
            case "NEUROLOGIST":
                return new DoctorType(NEURO_CONSULTATION, NEURO_OPERATION, State.HOME_NEURO,
                        State.HOSPITALIZED_NEURO, State.OPERATED_NEURO,
                        EnumSet.of(IllnessType.STROKE));
            default:
                return null;
        }
    }

    public static DoctorTypeFactory getInstance() {
        if (doctorTypeFactory == null) {
            doctorTypeFactory = new DoctorTypeFactory();
        }

        return doctorTypeFactory;
    }
}
