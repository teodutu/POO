package assets;

/**
 * Clasa abstracta ce reprezinta prototipul fiecarei carti ce va exista in pachet.
 */
public abstract class Card {
    private boolean legal;
    private int id, profit, penalty, kingBonus, queenBonus, numBonusItems;
    private Card bonusCard;

    /**
     * @param itemId            ID-ul fiecarui obiect ce urmeaza sa fie creat
     * @param isLegal           true daca obiectul e legal, false in caz contrar
     * @param itemProfit        profitul obectului curent
     * @param itemPenalty       penalizarea asociata obectului curent
     * @param itemKingBonus     bonusul de tip King al respectivului obiect
     * @param itemQueenBonus    bonusul de tip Queen al respectivului obiect
     * @param cardBonus         tipul de obiect bonus (null daca nu exista bonus)
     * @param bonusItems        numarul de obiecte bonus (0 daca nu exista bonus)
     */
    Card(final int itemId,
         final boolean isLegal,
         final int itemProfit,
         final int itemPenalty,
         final int itemKingBonus,
         final int itemQueenBonus,
         final Card cardBonus,
         final int bonusItems) {
        id = itemId;
        legal = isLegal;
        profit = itemProfit;
        penalty = itemPenalty;
        kingBonus = itemKingBonus;
        queenBonus = itemQueenBonus;
        bonusCard = cardBonus;
        numBonusItems = bonusItems;
    }

    public final boolean isLegal() {
        return legal;
    }

    public final boolean hasItemBonus() {
        return kingBonus > 0;
    }

    public final int getId() {
        return id;
    }

    public final int getProfit() {
        return profit;
    }

    public final int getPenalty() {
        return penalty;
    }

    public final int getKingBonus() {
        return kingBonus;
    }

    public final int getQueenBonus() {
        return queenBonus;
    }

    public final int getNumBonusItems() {
        return numBonusItems;
    }

    public final Card getBonus() {
        return bonusCard;
    }
}
