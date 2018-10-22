abstract class Operations {
    static ComplexNumber add(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.im + b.im, a.re + b.re);
    }

    static ComplexNumber multiply(ComplexNumber a, ComplexNumber b) {
        return new ComplexNumber(a.re * b.re - a.im * b.im, a.im * b.re + a.re * b.im);
    }
}
