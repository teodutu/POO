class Point {
    private float x, y;

    Point(float _x, float _y) {
        x = _x;
        y = _y;
    }

    void changeCoords(float newX, float newY) {
        x = newX;
        y = newY;
    }

    @Override
    public String toString() {
        return "(" + String.valueOf(x) + ", " + String.valueOf(y) + ")";
    }
}
