package tools;

import assets.Card;
import main.GameInput;
import players.Player;
import players.LeaderBoardUpdater;
import players.PlayerFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Clasa va rula jocul in sine, pornind de la inputul oferit de clasa GameInput si calculeaza
 * scorurile finale ale fiecarui jucator.
 */
public abstract class GameEngine {
    private static HashSet<Card> cardTable;
    private static ArrayList<Player> players;

    /**
     * Metoda creeaza HashSet-ul cardTable si lista de jucatori players plecand de la
     * inputul dat de clasa GameInput.
     *
     * @param gameInput contine id-urile cartilor din pachet si numele jucatorilor, accesibile
     *                  prin getterii si setterii corespunzatori
     */
    public static void getGameParameters(final GameInput gameInput) {
        cardTable = new HashSet<>();
        players = new ArrayList<>();

        Deck.getInstance().makeDeck(gameInput.getAssetIds(), cardTable);
        List<String> playerNames = gameInput.getPlayerNames();

        // se adauga fiecare jucator la ArrayList-ul players utilizand factory-ul PlayerFactory
        for (String player : playerNames) {
            players.add(PlayerFactory.getPlayer(player));
        }
    }

    /**
     * Metoda executa jocul pana cand fiecare dintre jucatori a fost serif de 2 ori.
     * Prin intermediul metodelor playMerchant, drawCards, playSheriff, fiecare jucator isi modifica
     * sacul, cartile din mana, taraba si numarul de monede
     */
    public static void playGame() {
        // fiecare jucator va fi serif de 2 ori cand vectorul de jucatori va fi parcurs de 2 ori
        int numTurns = players.size() * 2;

        for (int i = 0; i < numTurns; ++i) {
            // seriful este al i-lea jucator, pentru fiecare parcurgere a vectorului acestora
            Player currSheriff = players.get(i % players.size());

            // rundele 1, 2 si 4 pentru jucatorii ce nu sunt serifi
            for (Player currPlayer : players) {
                if (currPlayer != currSheriff) {
                    currPlayer.playMerchant();
                    currPlayer.drawCards();
                }
            }

            // seriful verifica toti jucatorii conform algoritmului sau
            currSheriff.playSheriff(players);
        }

        // se calculeaza scorurile fiecarui jucatori
        computeFinalScores();
    }

    /**
     * Metoda calculeaza scorurile acumulate de fiecare jucator la finalul unui joc.
     * Scorurile vor fi notate in campurile totalCoins ale jucatorilor.
     */
    private static void computeFinalScores() {
        int len = players.size();
        // practic, se creeaza un vector de frecventa pentru fiecare obiect ce admite bonus
        int[][] bonusTable = new int[cardTable.size()][len];
        int posInPlayers = 0;

        // fiecare jucator isi noteaza numarul de obiecte in bonusTable
        for (Player currPlayer : players) {
            currPlayer.countItemsWithBonus(bonusTable, posInPlayers++);
        }

        // se selecteaza jucatorii ce vor primi King bonus si Queen bonus
        for (Card currCard : cardTable) {
            int currItemId = currCard.getId();
            int kingBonus = 0, queenBonus = 0;

            for (int i = 0; i < len; ++i) {
                if (bonusTable[currItemId][i] > kingBonus) {
                    queenBonus = kingBonus;
                    kingBonus = bonusTable[currItemId][i];
                } else if (bonusTable[currItemId][i] > queenBonus
                        && bonusTable[currItemId][i] < kingBonus) {
                    queenBonus = bonusTable[currItemId][i];
                }
            }

            for (int i = 0; i < len; ++i) {
                if (bonusTable[currItemId][i] == kingBonus) {
                    players.get(i).addBonusCoins(currCard.getKingBonus());
                } else if (bonusTable[currItemId][i] == queenBonus) {
                    players.get(i).addBonusCoins(currCard.getQueenBonus());
                }
            }
        }
    }

    /**
     * Metoda creeaza clasamentul jucatorilor dupa scorul final.
     *
     * @return un ArrayList ce contine o pereche <String, Integer>: nume si scor, sortat dupa scor
     */
    public static ArrayList<Map.Entry<String, Integer>> getResults() {
        ArrayList<Map.Entry<String, Integer>> leaderBoard = new ArrayList<>();
        LeaderBoardUpdater updater = new LeaderBoardUpdater();

        // folosind mecanismul unui visitor pattern, fiecare jucator isi aduaga scorul in tabel
        for (Player currPlayer : players) {
            currPlayer.updateLeaderBoard(updater, leaderBoard);
        }

        // se sorteaza tabelul dupa scor
        leaderBoard.sort((Map.Entry<String, Integer> pair1, Map.Entry<String, Integer> pair2) ->
                pair2.getValue().compareTo(pair1.getValue()));

        return leaderBoard;
    }
}
