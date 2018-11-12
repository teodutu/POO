package main;

import tools.GameEngine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public final class Main {
    private static final class GameInputLoader {
        private final String mInputPath;

        private GameInputLoader(final String path) {
            mInputPath = path;
        }

        private GameInput load() {
            List<Integer> assetsIds = new ArrayList<>();
            List<String> playerOrder = new ArrayList<>();

            try {
                BufferedReader inStream = new BufferedReader(new FileReader(mInputPath));
                String assetIdsLine = inStream.readLine().replaceAll("[\\[\\] ']", "");
                String playerOrderLine = inStream.readLine().replaceAll("[\\[\\] ']", "");

                for (String strAssetId : assetIdsLine.split(",")) {
                    assetsIds.add(Integer.parseInt(strAssetId));
                }

                playerOrder.addAll(Arrays.asList(playerOrderLine.split(",")));
                inStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return new GameInput(assetsIds, playerOrder);
        }
    }

    private Main() { }

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0]);
        GameInput gameInput = gameInputLoader.load();

        // se creeaza structurile auxiliare jocului
        GameEngine.getGameParameters(gameInput);

        // jocul se desfasoara pana ce fiecare participant a fost serif de 2 ori
        GameEngine.playGame();

        // se calculeaza rezultatele ordonate descrescator
        ArrayList<Map.Entry<String, Integer>> leaderBoard = GameEngine.getResults();

        for (Map.Entry<String, Integer> pair : leaderBoard) {
            System.out.println(pair.getKey() + ": " + pair.getValue());
        }
    }
}
