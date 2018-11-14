package assets;

/**
 * Singleton ce reprezinta cartea Bread.
 * Fiecare carte de tip Bread va fi de fapt o referinta la obiectul BREAD din aceasta clasa
 */
public final class Bread extends Card {
    private static final Bread BREAD = new Bread();

    private static final int BREAD_ID = 2;
    private static final boolean BREAD_LEGAL = true;
    private static final int BREAD_PROFIT = 4;
    private static final int BREAD_PENALTY = 2;
    private static final int BREAD_KING = 15;
    private static final int BREAD_QUEEN = 10;
    private static final int BREAD_NUM_BONUS = 0;

    /**
     * Constructor privat ce se apeleaza o singura data pentru a crea obiectul BREAD.
     */
    private Bread() {
        super(BREAD_ID,
                BREAD_LEGAL,
                BREAD_PROFIT,
                BREAD_PENALTY,
                BREAD_KING,
                BREAD_QUEEN,
                null,
                BREAD_NUM_BONUS);
    }

    /**
     * Metoda ce permite accesarea unicului obiect de tip Bread, BREAD.
     * @return referinta catre BREAD
     */
    public static Bread getInstance() {
        return BREAD;
    }
}
