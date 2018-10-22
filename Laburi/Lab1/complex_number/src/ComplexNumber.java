class ComplexNumber {
    float im, re;

    ComplexNumber(float _re, float _im) {
        im = _im;
        re = _re;
    }

    @Override
    public String toString() {
        return (String.valueOf(re) + " + " + String.valueOf(im) + "i");
    }
}
