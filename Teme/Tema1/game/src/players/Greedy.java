package players;

import java.util.ArrayList;
import java.util.Map;

/**
 * Jucatorul Greedy va extinde clasa Basic, deoarece strategia sa se bazeaza pe cea de baza.
 */
public class Greedy extends Basic {
    private int roundsPlayed;

    Greedy() {
        roundsPlayed = 0;
    }

    /**
     * Cand este serif, Greedy ii verifica doar pe cei care nu au dat mita.
     * @param players  un ArrayList ce contine toti jucatorii
     */
    public final void playSheriff(final ArrayList<Player> players) {
        for (Player currPlayer : players) {
            if (!currPlayer.equals(this)) {
                if (currPlayer.hasBribe()) {
                    super.updateTotalCoins(currPlayer.getBribe());
                } else {
                    checkPlayer(currPlayer);
                }

                currPlayer.pushToStand();
            }
        }
    }

    /**
     * In rolul de comerciant, initial Greedy joaca la fel ca Basic.
     * Daca este o runda para si daca are mai putin de 6 carti in sac, se va apela metoda
     * playIllegal a lui Basic
     */
    @Override
    public final void playMerchant() {
        super.playMerchant();

        if ((++roundsPlayed & 1) == 0 && super.getBag().size() < super.getMaxBag()) {
            playIllegal();
        }
    }

    /**
     * Metoda apeleaza metoda update din ILeaderBoardUpdater, pentru jucatorul Greedy.
     * @param visitor      un tip de vizitator care mosteneste ILeaderBoardUpdater si care sa
     *                     execute operatia de update
     * @param leaderBoard  un ArrayList ce contine o pereche in care se va tine clasamentul
     */
    @Override
    public final void updateLeaderBoard(final ILeaderBoardUpdater visitor,
                                  final ArrayList<Map.Entry<String, Integer>> leaderBoard)  {
        visitor.update(this, leaderBoard);
    }
}
