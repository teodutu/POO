import java.text.DecimalFormat;

class Form {
    String colour;
    DecimalFormat df = new DecimalFormat(".##");

    float getArea() {
        return 0;
    }

    @Override
    public String toString() {
        return colour;
    }

    Form() {}

    Form(String col) {
        colour = col;
    }

    void print() {}
}
