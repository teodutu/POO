package assets;

import java.util.HashSet;

/**
 * Clasa abstracta ce implementeaza un design pattern de tip Factory pentru a returna
 * referinte la singleton-urile ce reprezinta cartile de joc.
 */
public abstract class CardFactory {
    /**
     * Primind un ID de carte si HashSet-ul in care se vor pastra catile ce pot primi bonus, metoda
     * returneaza cartea cu respectivul ID si daca aceasteia i se poate acorda bonus, o va adauga
     * in HashSet.
     * @param itemId    ID-ul fiecarei carti ce urmeaza sa fie returnata
     * @param cardTable HashSet ce stocheaza toate cartile ce pot primi bonus King / Queen
     * @return          o refetinta catre cardea ce are ID-ul itemId
     */
    public static Card getCard(final int itemId, final HashSet<Card> cardTable) {
        if (itemId == Apple.getInstance().getId()) {
            cardTable.add(Apple.getInstance());
            return Apple.getInstance();
        }

        if (itemId == Bread.getInstance().getId()) {
            cardTable.add(Bread.getInstance());
            return Bread.getInstance();
        }

        if (itemId == Chicken.getInstance().getId()) {
            cardTable.add(Chicken.getInstance());
            return Chicken.getInstance();
        }

        if (itemId == Cheese.getInstance().getId()) {
            cardTable.add(Cheese.getInstance());
            return Cheese.getInstance();
        }

        if (itemId == Barrel.getInstance().getId()) {
            return Barrel.getInstance();
        }

        if (itemId == Pepper.getInstance().getId()) {
            return Pepper.getInstance();
        }

        if (itemId == Silk.getInstance().getId()) {
            return Silk.getInstance();
        } else {
            return null;
        }
    }
}
