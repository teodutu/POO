package observers;

import entities.Hero;
import entities.Obstacle;
import game.GameState;

import java.util.Observable;
import java.util.Observer;

public class ObstacleObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        GameState gs = GameState.getInstance();

        for (Hero h : gs.getParty()) {
            for (Obstacle t : gs.getObstacles())

                if (h.getPosx() == t.getPosx() && h.getPosy() == t.getPosy()) {
                    System.out.println("Can't move there !");
                    gs.undo();
                }
        }
    }
}
