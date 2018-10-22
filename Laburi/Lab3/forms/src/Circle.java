class Circle extends Form {
    private float radius;

    Circle() {}

    Circle(float r, String col) {
        super(col);
        radius = r;
    }

    Circle(final Circle c) {
        this(c.radius, c.colour);
    }

    @Override
    public String toString() {
        return "Circle: " + colour + " " +  df.format(Math.PI * radius * radius);
    }

    void printCircleDimensions() {
        System.out.println("Radius: " + radius);
    }

    @Override
    void print() {
        printCircleDimensions();
    }
}
