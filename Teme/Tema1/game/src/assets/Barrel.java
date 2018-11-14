package assets;

/**
 * Singleton ce reprezinta cartea  Barrel.
 * Fiecare carte de tip Barrel va fi de fapt o referinta la obiectul BARREL din aceasta clasa.
 */
public final class Barrel extends Card {
    private static final Barrel BARREL = new Barrel();

    private static final int BARREL_ID = 12;
    private static final boolean BARREL_LEGAL = false;
    private static final int BARREL_PROFIT = 7;
    private static final int BARREL_PENALTY = 4;
    private static final int BARREL_KING = 0;
    private static final int BARREL_QUEEN = 0;
    private static final int BARREL_NUM_BONUS = 2;

    /**
     * Constructor privat ce se apeleaza o singura data pentru a crea obiectul BARREL.
     */
    private Barrel() {
        super(BARREL_ID,
                BARREL_LEGAL,
                BARREL_PROFIT,
                BARREL_PENALTY,
                BARREL_KING,
                BARREL_QUEEN,
                Bread.getInstance(),
                BARREL_NUM_BONUS);
    }

    /**
     * Metoda ce permite accesarea unicului obiect de tip Barrel, BARREL.
     * @return referinta catre BARREL
     */
    public static Barrel getInstance() {
        return BARREL;
    }
}
