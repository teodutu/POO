package utils;

import enums.IllnessType;
import enums.Urgency;

import java.util.HashMap;
import java.util.Map;


/**
 * Estimates the urgency based on the patient's illness and how severe the illness is manifested.
 */
public final class UrgencyEstimator {
    private final int eighty = 80;
    private final int seventy = 70;
    private final int sixty = 60;
    private final int fifty = 50;
    private final int forty = 40;
    private final int thirty = 30;
    private final int twenty = 20;
    private final int ten = 10;
    private static UrgencyEstimator instance;
    private final Map<Urgency, HashMap<IllnessType, Integer>> algorithm;

    private UrgencyEstimator() {
        algorithm = new HashMap<Urgency, HashMap<IllnessType, Integer>>() {
            {
                put(Urgency.IMMEDIATE,
                        new HashMap<IllnessType, Integer>() {
                            {
                                put(IllnessType.ABDOMINAL_PAIN, sixty);
                                put(IllnessType.ALLERGIC_REACTION, fifty);
                                put(IllnessType.BROKEN_BONES, eighty);
                                put(IllnessType.BURNS, forty);
                                put(IllnessType.CAR_ACCIDENT, thirty);
                                put(IllnessType.CUTS, fifty);
                                put(IllnessType.FOOD_POISONING, fifty);
                                put(IllnessType.HEART_ATTACK, 0);
                                put(IllnessType.HEART_DISEASE, forty);
                                put(IllnessType.HIGH_FEVER, seventy);
                                put(IllnessType.PNEUMONIA, eighty);
                                put(IllnessType.SPORT_INJURIES, seventy);
                                put(IllnessType.STROKE, 0);
                            }
                        });

                put(Urgency.URGENT,
                        new HashMap<IllnessType, Integer>() {
                            {
                                put(IllnessType.ABDOMINAL_PAIN, forty);
                                put(IllnessType.ALLERGIC_REACTION, thirty);
                                put(IllnessType.BROKEN_BONES, fifty);
                                put(IllnessType.BURNS, twenty);
                                put(IllnessType.CAR_ACCIDENT, twenty);
                                put(IllnessType.CUTS, thirty);
                                put(IllnessType.HEART_ATTACK, 0);
                                put(IllnessType.FOOD_POISONING, twenty);
                                put(IllnessType.HEART_DISEASE, twenty);
                                put(IllnessType.HIGH_FEVER, forty);
                                put(IllnessType.PNEUMONIA, fifty);
                                put(IllnessType.SPORT_INJURIES, fifty);
                                put(IllnessType.STROKE, 0);
                            }
                        });

                put(Urgency.LESS_URGENT,
                        new HashMap<IllnessType, Integer>() {
                            {
                                put(IllnessType.ABDOMINAL_PAIN, ten);
                                put(IllnessType.ALLERGIC_REACTION, ten);
                                put(IllnessType.BROKEN_BONES, twenty);
                                put(IllnessType.BURNS, ten);
                                put(IllnessType.CAR_ACCIDENT, ten);
                                put(IllnessType.CUTS, ten);
                                put(IllnessType.FOOD_POISONING, 0);
                                put(IllnessType.HEART_ATTACK, 0);
                                put(IllnessType.HEART_DISEASE, ten);
                                put(IllnessType.HIGH_FEVER, 0);
                                put(IllnessType.PNEUMONIA, ten);
                                put(IllnessType.SPORT_INJURIES, twenty);
                                put(IllnessType.STROKE, 0);
                            }
                        });
            }
        };
    }

    public static UrgencyEstimator getInstance() {
        if (instance == null) {
            instance = new UrgencyEstimator();
        }
        return instance;
    }

    //called by doctors and nurses
    public Urgency estimateUrgency(IllnessType illnessType, int severity) {

        if (severity >= algorithm.get(Urgency.IMMEDIATE).get(illnessType)) {
            return Urgency.IMMEDIATE;
        } else if (severity >= algorithm.get(Urgency.URGENT).get(illnessType)) {
            return Urgency.URGENT;
        } else if (severity >= algorithm.get(Urgency.LESS_URGENT).get(illnessType)) {
            return Urgency.LESS_URGENT;
        }

        return Urgency.NON_URGENT;
    }
}
