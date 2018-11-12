package players;

import java.util.ArrayList;
import java.util.Map;

/**
 * Wizard il extinde pe Basic, deoarece pentru a fi mai bun decat acesta, este suficient sa nu
 * piarda bani verificandu-i pe cei (aproape) sinceri, care nu dau mita.
 */
public class Wizard extends Basic {
    /**
     * Doar cei ce au dat mita sunt suspecti si, deci, doar ei vor fi verificati.
     * Altfel, de ce ar mai fi dat mita?
     * @param players  un ArrayList ce contine toti jucatorii
     */
    @Override
    public void playSheriff(final ArrayList<Player> players) {
        for (Player currPlayer : players) {
            if (currPlayer.hasBribe() && !currPlayer.equals(this)) {
                checkPlayer(currPlayer);
            }
        }
    }

    /**
     * Metoda apeleaza metoda update din ILeaderBoardUpdater, pentru jucatorul Wizard.
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
