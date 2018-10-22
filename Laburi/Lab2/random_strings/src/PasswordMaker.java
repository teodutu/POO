import java.util.Scanner;

public class PasswordMaker {
    private int age;
    private static final int MAGIC_NUMBER = 15;
    private String MAGIC_STRING, firstName, lastName;

    private PasswordMaker(String _firstName, String _lastName, int _age) {
        firstName = _firstName;
        lastName = _lastName;
        age = _age;

        RandomStringGenerator gen = new RandomStringGenerator(23, "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                        "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toLowerCase() + "0123456789");
        MAGIC_STRING = gen.next();
    }

    private String getPassword() {
        RandomStringGenerator gen = new RandomStringGenerator(10, MAGIC_STRING);
        String magic = gen.next();
        gen = new RandomStringGenerator(MAGIC_NUMBER, magic);

        return firstName.substring(firstName.length() - age % 3) + gen.next() + String.valueOf(age + lastName.length());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstName = in.next(), lastName = in.next();
        int age = in.nextInt();

        PasswordMaker pm = new PasswordMaker(firstName, lastName, age);
        System.out.println(pm.getPassword());
    }
}
