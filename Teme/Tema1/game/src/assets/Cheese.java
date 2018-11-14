package assets;

/**
 * Singleton ce reprezinta cartea Cheese.
 * Fiecare carte de tip Cheese va fi de fapt o referinta la obiectul CHEESE din aceasta clasa.
 */
public final class Cheese extends Card {
    private static final Cheese CHEESE = new Cheese();

    private static final int CHEESE_ID = 1;
    private static final boolean CHEESE_LEGAL = true;
    private static final int CHEESE_PROFIT = 3;
    private static final int CHEESE_PENALTY = 2;
    private static final int CHEESE_KING = 15;
    private static final int CHEESE_QUEEN = 10;
    private static final int CHEESE_NUM_BONUS = 0;

    /**
     * Constructor privat ce se apeleaza o singura data pentru a crea obiectul CHEESE.
     */
    private Cheese() {
        super(CHEESE_ID,
                CHEESE_LEGAL,
                CHEESE_PROFIT,
                CHEESE_PENALTY,
                CHEESE_KING,
                CHEESE_QUEEN,
                null,
                CHEESE_NUM_BONUS);
    }

    /**
     * Metoda ce permite accesarea unicului obiect de tip Cheese, CHEESE.
     * @return referinta catre CHEESE
     */
    public static Cheese getInstance() {
        return CHEESE;
    }
}
