package players;

import assets.Apple;
import assets.Card;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

/**
 * Clasa implementeaza strategia jucatorului de baza.
 * Preia ca atare toate metodele din Player, mai putin pe cele abstracte.
 * Natura cerintei este de o asemenea maniera incat toate celelatle clase extind aceasta clasa.
 */
public class Basic extends Player {
    /**
     * Metoda ilustreaza modul in care Basic se comporta ca serif: verifica tot.
     *
     * @param players  un ArrayList ce contine toti jucatorii
     */
    public void playSheriff(final ArrayList<Player> players) {
        for (Player currPlayer : players) {
            if (!currPlayer.equals(this)) {
                checkPlayer(currPlayer);
                currPlayer.pushToStand();
            }
        }
    }

    /**
     * Se implementeaza strategia de comerciant a jucatorului Basic.
     * Acesta incearca sa joace exclusiv carti legale, iar daca nu dispune de niciuna, va juca o
     * crate ilegala, mai exact pe cea cu profitul maxim.
     */
    public void playMerchant() {
        playLegal();

        if (super.getBag().isEmpty()) {
            playIllegal();
            setDeclaredCard(Apple.getInstance());
        }
    }

    /**
     * Incercand sa joace legal, Basic va alege cartile cel mai des intalnite in mana (sau,
     * in caz de egalitate, pe cele cu profiturile cele mai mari) si le va pune in sac.
     */
    final void playLegal() {
        // se va folosi un vector de frecventa pentru a determina cel mai des intalnit tip de carte
        int[] freq = new int[super.getMaxCardTypes()];
        int maxFreq = 0, maxProfit = 0;
        LinkedList<Card> cardsInHand = super.getCardsInHand();

        for (Card currCard : cardsInHand) {
            int currId = currCard.getId();

            if (currCard.isLegal()) {
                ++freq[currId];
            }
        }

        // se gaseste cartea cu frecventa maxima si se seteaza ca obiect declarat
        for (Card currCard : cardsInHand) {
            int currId = currCard.getId();
            int currProfit = currCard.getProfit();

            if (currCard.isLegal()
                    && (maxFreq == freq[currId]
                    && maxProfit < currProfit)
                    || maxFreq < freq[currId]) {
                maxFreq = freq[currId];
                setDeclaredCard(currCard);
                maxProfit = currProfit;
            }
        }

        // se adauga toate cartile de tipul celei declarate in sac si se scot concomitent din mana
        Card declaredCard = super.getDeclaredCard();

        for (int i = 0; i < maxFreq; ++i) {
            addItemToBag(declaredCard);
            discardItem(declaredCard);
        }
    }

    /**
     * Metoda implementeaza strategia ilegala a lui Basic, prin care acesta pune in sac doar cartea
     * cu profitul maxim.
     */
    final void  playIllegal() {
        Card bestCard = null;

        for (Card currCard : super.getCardsInHand()) {
            if (!currCard.isLegal()
                    && (bestCard == null
                    || bestCard.getProfit() < currCard.getProfit())) {
                bestCard = currCard;
            }
        }

        if (bestCard != null) {
            addItemToBag(bestCard);
            discardItem(bestCard);
        }
    }

    /**
     * Metoda apeleaza metoda update din ILeaderBoardUpdater, pentru instanta curenta.
     * Se va suprascrie de toate clasele ce mostenesc Basic.
     * @param visitor      un tip de vizitator care mosteneste ILeaderBoardUpdater si care sa
     *                     execute operatia de update
     * @param leaderBoard  un ArrayList ce contine o pereche in care se va tine clasamentul
     */
    @Override
    public void updateLeaderBoard(final ILeaderBoardUpdater visitor,
                                  final ArrayList<Map.Entry<String, Integer>> leaderBoard) {
        visitor.update(this, leaderBoard);
    }
}
