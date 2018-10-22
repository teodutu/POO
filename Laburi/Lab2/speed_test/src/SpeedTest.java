public class SpeedTest {
    public static void main(String[] args) {
        long start = System.nanoTime();
        int t = 2 + 3;
        System.out.println(System.nanoTime() - start);

        start = System.nanoTime();
        Integer tt = 2 + 3;
        System.out.println(System.nanoTime() - start);

        String[] str = new String[100000];

        for (String s : str) {
            s = new String("abc");
//            s = "abc";
        }

        System.out.println(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
    }
}
