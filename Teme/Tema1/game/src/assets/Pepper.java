package assets;

/**
 * Singleton ce reprezinta cartea Pepper.
 * Fiecare carte de tip Pepper va fi de fapt o referinta la obiectul PEPPER din aceasta clasa.
 */

public final class Pepper extends Card {
    private static final Pepper PEPPER = new Pepper();

    private static final int PEPPER_ID = 11;
    private static final boolean PEPPER_LEGAL = false;
    private static final int PEPPER_PROFIT = 8;
    private static final int PEPPER_PENALTY = 4;
    private static final int PEPPER_KING = 0;
    private static final int PEPPER_QUEEN = 0;
    private static final int PEPPER_NUM_BONUS = 2;

    /**
     * Constructor privat ce se apeleaza o singura data pentru a crea obiectul PEPPER.
     */

    private Pepper() {
        super(PEPPER_ID,
                PEPPER_LEGAL,
                PEPPER_PROFIT,
                PEPPER_PENALTY,
                PEPPER_KING,
                PEPPER_QUEEN,
                Chicken.getInstance(),
                PEPPER_NUM_BONUS);
    }

    /**
     * Metoda ce permite accesarea unicului obiect de tip Pepper, PEPPER.
     * @return referinta catre PEPPER
     */

    public static Pepper getInstance() {
        return PEPPER;
    }
}
