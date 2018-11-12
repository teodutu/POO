package players;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

/**
 * Clasa implementeaza interfata LeaderBoardUpdaterVisitor pentru a implementa "vizitarea"
 * fiecarui jucator in vederea adaugarii scorului acestuia in clasament.
 */
public final class LeaderBoardUpdater implements ILeaderBoardUpdater {
    @Override
    public void update(final Basic basicPlayer,
                       final ArrayList<Map.Entry<String, Integer>> leaderBoard) {
        leaderBoard.add(new AbstractMap.SimpleEntry<>("BASIC", basicPlayer.getScore()));
    }

    @Override
    public void update(final Greedy greedyPlayer,
                       final ArrayList<Map.Entry<String, Integer>> leaderBoard) {
        leaderBoard.add(new AbstractMap.SimpleEntry<>("GREEDY", greedyPlayer.getScore()));
    }

    @Override
    public void update(final Bribed bribedPlayer,
                       final ArrayList<Map.Entry<String, Integer>> leaderBoard) {
        leaderBoard.add(new AbstractMap.SimpleEntry<>("BRIBED", bribedPlayer.getScore()));

    }

    @Override
    public void update(final Wizard wizardPlayer,
                       final ArrayList<Map.Entry<String, Integer>> leaderBoard) {
        leaderBoard.add(new AbstractMap.SimpleEntry<>("WIZARD", wizardPlayer.getScore()));

    }
}
