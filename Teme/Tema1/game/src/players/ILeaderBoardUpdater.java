package players;

import java.util.ArrayList;
import java.util.Map;

/**
 * Interfata va fi mostenita de LeaderBoardUpdater si contine metode ce aduauga fiecare jucator in
 * clasament.
 */
public interface ILeaderBoardUpdater {
    void update(Basic basicPlayer, ArrayList<Map.Entry<String, Integer>> leaderBoard);

    void update(Greedy greedyPlayer, ArrayList<Map.Entry<String, Integer>> leaderBoard);

    void update(Bribed bribedPlayer, ArrayList<Map.Entry<String, Integer>> leaderBoard);

    void update(Wizard wizardPlayer, ArrayList<Map.Entry<String, Integer>> leaderBoard);
}
