class Triangle extends Form {
    private float height, base;

    Triangle() {}

    Triangle(float h, float b, String col) {
        super(col);
        height = h;
        base = b;
    }

    Triangle(final Triangle t) {
        this(t.height, t.base, t.colour);
    }

    @Override
    public String toString() {
        return "Triunghi: " + colour + " " + df.format(height * base / 2);
    }

    boolean equals(Triangle t) {
        return height == t.height && base == t.base && colour == t.colour;
    }

    void printTriangleDimensions() {
        System.out.println("Height: " + height + "; Base: " + base);
    }

    @Override
    void print() {
        printTriangleDimensions();
    }
}
