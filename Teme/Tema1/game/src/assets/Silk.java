package assets;

/**
 * Singleton ce reprezinta cartea Silk.
 * Fiecare carte de tip Silk va fi de fapt o referinta la obiectul SILK din aceasta clasa.
 */
public final class Silk extends Card {
    private static final Silk SILK = new Silk();

    private static final int SILK_ID = 10;
    private static final boolean SILK_LEGAL = false;
    private static final int SILK_PROFIT = 9;
    private static final int SILK_PENALTY = 4;
    private static final int SILK_KING = 0;
    private static final int SILK_QUEEN = 0;
    private static final int SILK_NUM_BONUS = 3;

    /**
     * Constructor privat ce se apeleaza o singura data pentru a crea obiectul SILK.
     */
    private Silk() {
        super(SILK_ID,
                SILK_LEGAL,
                SILK_PROFIT,
                SILK_PENALTY,
                SILK_KING,
                SILK_QUEEN,
                Cheese.getInstance(),
                SILK_NUM_BONUS);
    }

    /**
     * Metoda ce permite accesarea unicului obiect de tip Silk, SILK.
     * @return referinta catre SILK
     */
    public static Silk getInstance() {
        return SILK;
    }
}
