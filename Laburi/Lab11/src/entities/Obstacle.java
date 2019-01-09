package entities;

public class Obstacle {
    private int posX, posY;

    public Obstacle(int x, int y) {
        posX = x;
        posY = y;
    }

    /* Getters and setters */
    public int getPosy() {
        return posY;
    }

    public int getPosx() {
        return posX;
    }
}
