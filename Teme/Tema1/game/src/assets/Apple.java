package assets;

/**
 * Singleton ce reprezinta cartea Apple.
 * Fiecare carte de tip Apple va fi de fapt o referinta la obiectul APPLE din aceasta clasa.
 */
public final class Apple extends Card {
    private static final Apple APPLE = new Apple();

    private static final int APPLE_ID = 0;
    private static final boolean APPLE_LEGAL = true;
    private static final int APPLE_PROFIT = 2;
    private static final int APPLE_PENALTY = 2;
    private static final int APPLE_KING = 20;
    private static final int APPLE_QUEEN = 10;
    private static final int APPLE_NUM_BONUS = 0;

    /**
     * Constructor privat ce se apeleaza o singura data pentru a crea obiectul APPLE.
     */
    private Apple() {
         super(APPLE_ID,
                APPLE_LEGAL,
                APPLE_PROFIT,
                APPLE_PENALTY,
                APPLE_KING,
                APPLE_QUEEN,
                null,
                APPLE_NUM_BONUS);
    }

    /**
     * Metoda ce permite accesarea unicului obiect de tip Apple, APPLE.
     * @return referinta catre APPLE
     */
    public static Apple getInstance() {
        return APPLE;
    }
}
