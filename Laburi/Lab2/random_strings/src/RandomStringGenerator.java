import java.util.Random;

class RandomStringGenerator {
    private int randLen;
    private String randAlph;

    RandomStringGenerator(int len, String alphabet) {
        randLen = len;
        randAlph = alphabet;
    }

    String next() {
        char[] str = new char[randLen];
        Random gen = new Random();
        int alphLen = randAlph.length();

        for (int i = 0; i < randLen; ++i) {
            str[i] = randAlph.charAt(gen.nextInt(alphLen));
        }

        return new String(str);
    }
}
