import java.util.Scanner;

public class ComplexNumberTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float re, im;

        re = sc.nextFloat(); im = sc.nextFloat();
        ComplexNumber z1 = new ComplexNumber(re, im);

        re = sc.nextFloat(); im = sc.nextFloat();
        ComplexNumber z2 = new ComplexNumber(re, im);

        System.out.println("Sum = " + Operations.add(z1, z2).toString());
        System.out.println("Product = " + Operations.multiply(z1, z2).toString());
    }
}
