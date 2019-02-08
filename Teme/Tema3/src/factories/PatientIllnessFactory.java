package factories;

import enums.IllnessType;

/**
 * Transforma  bolile din forma de string in forma de elemente ale enumului "IllnessType".
 */
public class PatientIllnessFactory {
    private static PatientIllnessFactory illnessFactory;

    /**
     * Se returneaza boala cprespunzatoare stringului citit din fisierul de intrare.
     *
     * @param illnessString boala citita sub forma de string
     * @return              boala returnata sub forma de element al enumului "IllnessType"
     */
    public IllnessType getIllnessType(String illnessString) {
        switch (illnessString) {
            case "ABDOMINAL_PAIN":
                return IllnessType.ABDOMINAL_PAIN;
            case "ALLERGIC_REACTION":
                return IllnessType.ALLERGIC_REACTION;
            case "HEART_DISEASE":
                return IllnessType.HEART_DISEASE;
            case "BROKEN_BONES":
                return IllnessType.BROKEN_BONES;
            case "BURNS":
                return IllnessType.BURNS;
            case "CAR_ACCIDENT":
                return IllnessType.CAR_ACCIDENT;
            case "CUTS":
                return IllnessType.CUTS;
            case "FOOD_POISONING":
                return IllnessType.FOOD_POISONING;
            case "HEART_ATTACK":
                return IllnessType.HEART_ATTACK;
            case "HIGH_FEVER":
                return IllnessType.HIGH_FEVER;
            case "PNEUMONIA":
                return IllnessType.PNEUMONIA;
            case "SPORT_INJURIES":
                return IllnessType.SPORT_INJURIES;
            case "STROKE":
                return IllnessType.STROKE;
            default:
                return null;
        }
    }

    public static PatientIllnessFactory getInstance() {
        if (illnessFactory == null) {
            illnessFactory = new PatientIllnessFactory();
        }

        return illnessFactory;
    }
}
