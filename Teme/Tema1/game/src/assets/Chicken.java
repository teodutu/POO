package assets;

/**
 * Singleton ce reprezinta cartea Chicken.
 * Fiecare carte de tip Chicken va fi de fapt o referinta la obiectul CHICKEN din aceasta clasa.
 */

public final class Chicken extends Card {
    private static final Chicken CHICKEN = new Chicken();

    private static final int CHICKEN_ID = 3;
    private static final boolean CHICKEN_LEGAL = true;
    private static final int CHICKEN_PROFIT = 4;
    private static final int CHICKEN_PENALTY = 2;
    private static final int CHICKEN_KING = 10;
    private static final int CHICKEN_QUEEN = 5;
    private static final int CHICKEN_NUM_BONUS = 0;

    /**
     * Constructor privat ce se apeleaza o singura data pentru a crea obiectul CHICKEN.
     */

    private Chicken() {
        super(CHICKEN_ID,
                CHICKEN_LEGAL,
                CHICKEN_PROFIT,
                CHICKEN_PENALTY,
                CHICKEN_KING,
                CHICKEN_QUEEN,
                null,
                CHICKEN_NUM_BONUS);
    }

    /**
     * Metoda ce permite accesarea unicului obiect de tip Chicken, CHICKEN.
     * @return referinta catre CHICKEN
     */

    public static Chicken getInstance() {
        return CHICKEN;
    }
}
