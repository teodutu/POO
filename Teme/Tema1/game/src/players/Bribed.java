package players;

import assets.Apple;
import assets.Card;

import java.util.ArrayList;
import java.util.Map;

/**
 * Clasa implementeaza strategia jucatorului Bribed, plecand de la cea a lui Basic, caruia
 * ii extinde clasa.
 */
public class Bribed extends Basic {
    private static final int MAX_BAG_LOW_CASH = 2;
    private static final int MIN_COINS = 5;
    private static final int LOW_BRIBE = 5;
    private static final int HIGH_BRIBE = 10;
    private Player leftPlayer = null, rightPlayer = null;

    /**
     * Ca serif, Bribed isi verifica mereu vecinii din stanga si din dreapta.
     * @param players  un ArrayList ce contine toti jucatorii
     */
    @Override
    public final void playSheriff(final ArrayList<Player> players) {
        //  se determina vecinii lui Bribed, daca acestia nu s-au determinat deja
        if (leftPlayer == null) {
            findPlayersToCheck(players);
        }

        // se verifica vecinul stang, apoi cel drept
        if (leftPlayer != this) {
            checkPlayer(leftPlayer);
            leftPlayer.pushToStand();
        }

        if (rightPlayer != leftPlayer) {
            checkPlayer(rightPlayer);
            rightPlayer.pushToStand();
        }
    }

    /**
     * Metoda cauta indexul instantei curente in players si seteaza leleftPlayer si
     * rightPlayer ca fiind vecinii din stanga, respectiv dreapta ai acestuia.
     * @param players  un ArrayList-ul ce contine jucatorii
     */
    private void findPlayersToCheck(final ArrayList<Player> players) {
        int bribedIndex = players.indexOf(this);

        leftPlayer = players.get(bribedIndex == 0
                     ? players.size() - 1 : bribedIndex - 1);

        rightPlayer = players.get((bribedIndex + 1) % players.size());
    }

    /**
     * In rolul de comerciant, Bribed pune in sac cat mai multe carti ilegale (atatea cat ii permit
     * banii) si pune 5 monede daca are mai putin de 3 carti sau 10 in caz contrar.
     * Daca nu are carti ilegale in mana, sau daca are mai putin de 5 bani, joaca legal, ca Basic.
     */
    @Override
    public final void playMerchant() {
        // mai intai se inventariaza cartile ilegale
        ArrayList<Card> illegalsInHand = new ArrayList<>();

        for (Card currCard : super.getCardsInHand()) {
            if (!currCard.isLegal()) {
                illegalsInHand.add(currCard);
            }
        }

        // in functie de existenta cartilor ilegale in mana si de numarul de monede ramase
        // se decide strategia de joc
        if (illegalsInHand.size() == 0 || super.getTotalCoins() < MIN_COINS) {
            super.setBribe(0);
            super.playLegal();
        } else {
            // numarul maxim de carti care se vor pune in sac se decide in functie de numarul de
            // monede disponibile
            int maxItems = super.getTotalCoins() < HIGH_BRIBE
                                                   ? MAX_BAG_LOW_CASH : super.getMaxBag();

            // se sorteaza cartile ilegale descrescator dupa profit
            super.setDeclaredCard(Apple.getInstance());
            illegalsInHand.sort((final Card card1, final Card card2) ->
                    card2.getProfit() - card1.getProfit());

            // se pun cat mai multe carti ilegale posibil in sac si se adauga mita
            for (int i = 0; i < maxItems && i < illegalsInHand.size(); ++i) {
                Card currCard = illegalsInHand.get(i);

                super.getBag().add(currCard);
                super.getCardsInHand().remove(currCard);
            }

            super.setBribe(super.getBag().size() <= MAX_BAG_LOW_CASH ? LOW_BRIBE : HIGH_BRIBE);
        }
    }

    /**
     * Metoda apeleaza metoda update din ILeaderBoardUpdater, pentru jucatorul Bribed.
     * @param visitor      un tip de vizitator care mosteneste ILeaderBoardUpdater si care sa
     *                     execute operatia de update
     * @param leaderBoard  un ArrayList ce contine o pereche in care se va tine clasamentul
     */
    @Override
    public final void updateLeaderBoard(final ILeaderBoardUpdater visitor,
                                  final ArrayList<Map.Entry<String, Integer>> leaderBoard) {
        visitor.update(this, leaderBoard);
    }
}
