package players;

/**
 * Clasa creeaza cate un nou jucator, in functie de String-ul primit ca parametru, in
 * metoda getPlayer.
 */
public abstract class PlayerFactory {
    public static Player getPlayer(final String playerName) {
        switch (playerName) {
            case "basic":
                return new Basic();

            case "greedy":
                return new Greedy();

            case "bribed":
                return new Bribed();

            case "wizard":
                return new Wizard();

            default:
                return null;
        }
    }
}
