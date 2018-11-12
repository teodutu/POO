package players;

import assets.Card;
import tools.Deck;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * Clasa implementeaza toate metodele de care are nevoie un jucator si contine toate campurile
 * necesare acestuia.
 * Metodele abstracte playMerchant, playSheriff si updateLeaderBoard sunt lasate exclusiv la
 * discretia fiecarui jucator, pentru a le implementa conform strategiei sale.
 */
public abstract class Player {
    private static final int MAX_BAG = 5;
    private static final int MAX_CARDS = 6;
    private static final int MAX_CARD_TYPES = 13;
    private static final int START_COINS = 50;

    private HashMap<Card, Integer> merchantStand;
    private LinkedList<Card> cardsInHand;
    private ArrayList<Card> bag;
    private int totalCoins, bribe;
    private Card declaredCard;

    /**
     * Se initializeaza campurile pe care le foloseste un jucator si se trag primele carti din mana.
     */
    Player() {
        totalCoins = START_COINS;
        bribe = 0;
        declaredCard = null;

        merchantStand = new HashMap<>();
        cardsInHand = new LinkedList<>();
        bag = new ArrayList<>();

        drawCards();
    }

    final boolean hasBribe() {
        return bribe > 0;
    }

    final int getBribe() {
        totalCoins -= bribe;
        return bribe;
    }

    final void setBribe(final int bribeValue) {
        bribe = bribeValue;
    }

    final LinkedList<Card> getCardsInHand() {
        return cardsInHand;
    }

    final void discardItem(final Card card) {
        cardsInHand.remove(card);
    }

    final ArrayList<Card> getBag() {
        return bag;
    }

    final void addItemToBag(final Card card) {
        bag.add(card);
    }

    final Card getDeclaredCard() {
        return declaredCard;
    }

    final int getMaxBag() {
        return MAX_BAG;
    }

    final int getMaxCardTypes() {
        return MAX_CARD_TYPES;
    }

    final void checkPlayer(final Player player) {
        int exchangedSum = player.calculatePenalty();

        totalCoins += exchangedSum;
        player.exchangeCoins(exchangedSum);
    }

    /**
     * Metoda calculeaza penalizarea platita de comerciant serifului.
     * Este o suma cu semn, astfel incat atunci cand suma se va scadea din numarul total de bani ai
     * comericantului si se va adauga la cea a serifului, regulile se vor respecta si in cazul in
     * care seriful ar trebui de fapt sa plateasca.
     * @return  suma cu semn pe care comerciantul o da serifului
     */
    private int calculatePenalty() {
        int exchangedSum = 0;  // suma data de comerciant serifului
        boolean liar = false;
        ArrayList<Card> removedCards = new ArrayList<>();

        // se pun inapoi in pachet cartile ilegale si se va adauga penalizarea corespunzatoare lor
        // la exchangedSum
        for (Card currCard : bag) {
            if (!currCard.isLegal() || currCard != declaredCard) {
                liar = true;
                exchangedSum += currCard.getPenalty();
                removedCards.add(currCard);
                Deck.getInstance().addCard(currCard);
            }
        }

        // daca nu au fost gasite carti ilegale, la exchangedSum se va adauga penalizarea
        // corespunzatoare cartilor legale
        if (!liar) {
            for (Card currCard : bag) {
                exchangedSum -= currCard.getPenalty();
            }
        }

        bag.removeAll(removedCards);
        return exchangedSum;
    }

    private void exchangeCoins(final int numCoins) {
        totalCoins -= numCoins;
    }

    /**
     * Se completeaza cardsInHand pana la MAX_CARDS.
     */
    public final void drawCards() {
        cardsInHand.addAll(Deck.getInstance().giveCards(MAX_CARDS - cardsInHand.size()));
    }

    /**
     * Metoda pune pe taraba unui jucator (adauga in HashMap-ul merchantStand) o pereche formata
     * dintr-o carte si numarul sau de aparitii.
     */
    final void pushToStand() {
        for (Card currCard : bag) {
            pushItemToStand(currCard);

            // daca se gaseste o carte ilegala, se pun pe taraba si cartile pe care aceasta le ofera
            // ca bonus
            if (!currCard.isLegal()) {
                Card currBonus = currCard.getBonus();

                for (int i = 0; i < currCard.getNumBonusItems(); ++i) {
                    pushItemToStand(currBonus);
                }
            }
        }

        bag.clear();
    }

    /**
     * Metoda pune o carte pe taraba jucatorului curent si, daca pe respectiva taraba exista deja
     * acest obiect, ii creste numarul de aparitii.
     * Daca aceasta este goala, o pune cu un numar de aparitii = 1.
     * @param card  cartea ce urmeaza sa fie adaugata pe taraba
     */
    private void pushItemToStand(final Card card) {
        try {
            int numItemsOnStand = merchantStand.get(card);
            merchantStand.put(card, numItemsOnStand + 1);
        } catch (NullPointerException nullPtrExc) {
            merchantStand.put(card, 1);
        }
    }

    /**
     * Metoda calculeaza scorul obtinut de un jucator doar din profiturile aduse de obiectele de
     * pe taraba sa.
     * @return  scorul obtinut de jucator
     */
    final int getScore() {
        int score = totalCoins;

        for (Map.Entry<Card, Integer> currItem : merchantStand.entrySet()) {
            score += currItem.getKey().getProfit() * currItem.getValue();
        }

        return score;
    }

    /**
     * Metoda noteaza in matricea primita ca parametru numarul de obiecte din fiecare tip ce
     * admit bonus King sau Queen.
     * @param bonusTable    matricea care inventariaza obiectele eligibile pentru bonus
     * @param posInPlayers  pozitia in ArrayList-ul de jucatori a celui curent, pentru a se completa
     *                      bonusTable la indicii corecti
     */
    public final void countItemsWithBonus(final int[][] bonusTable, final int posInPlayers) {
        for (Map.Entry<Card, Integer> currItem : merchantStand.entrySet()) {
            Card currCardKey = currItem.getKey();

            if (currCardKey.hasItemBonus()) {
                bonusTable[currCardKey.getId()][posInPlayers] += currItem.getValue();
            }
        }
    }

    public final void addBonusCoins(final int numCoins) {
        totalCoins += numCoins;
    }

    final int getTotalCoins() {
        return totalCoins;
    }

    final void updateTotalCoins(final int exchangedSum) {
        totalCoins += exchangedSum;
    }

    final void setDeclaredCard(final Card newDeclaredCard) {
        declaredCard = newDeclaredCard;
    }

    /**
     * Fiecare jucator ce extinde aceasta clasa va implementa propria sa strategia sa de comerciant.
     */
    public abstract void playMerchant();

    /**
     * Fiecare jucator ce extinde aceasta clasa va implementa propria sa strategia sa de serif.
     * @param players  un ArrayList ce contine toti jucatorii
     */
    public abstract void playSheriff(ArrayList<Player> players);

    /**
     * Metoda apeleaza metoda update din ILeaderBoardUpdater, pentru fiecare jucator ce extinde
     * aceasta clasa.
     * @param visitor      un tip de vizitator care implementeaza ILeaderBoardUpdater si care sa
     *                     execute operatia de update
     * @param leaderBoard  un ArrayList ce contine o pereche in care se va tine clasamentul
     */
    public abstract void updateLeaderBoard(ILeaderBoardUpdater visitor,
                                  ArrayList<Map.Entry<String, Integer>> leaderBoard);
}
