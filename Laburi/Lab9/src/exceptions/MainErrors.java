package exceptions;

public class MainErrors {
    private static void outOfMemory() {
        int[] v = new int[2000000000];
    }

    private static void stackOverflow() {
        stackOverflow();
    }

    private static String showcaseFinally() {
        try {
            return "Still returned ok";
        } catch (Exception e) {
            System.out.println(e.getCause().toString());
            System.out.println(e.getMessage());
            e.printStackTrace();
            return "Caught exception";
        } finally {
            System.out.println("Finally");
        }
    }

    public static void main(String[] args) {
        // outOfMemory();
        // stackOverflow();

        Calculator calc = new Calculator();

        // System.out.println(calc.add(2000000000, 1000000000));
        // System.out.println(calc.add(-2000000000, -1000000000));

        System.out.println(showcaseFinally());
    }

}
