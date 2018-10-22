import java.util.Scanner;

public class TestForms {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        Triangle t = new Triangle(in.nextFloat(), in.nextFloat(), in.next());
        Circle c = new Circle(in.nextFloat(), in.next());

        System.out.println(t.toString());
        System.out.println(c.toString());

        Triangle tt = new Triangle(t);

        System.out.println(t.equals(tt));

        Form[] forms = new Form[3];
        forms[0] = new Triangle(t);
        forms[1] = new Triangle(t);
        forms[2] = new Circle(c);

        for (Form form : forms) {
            System.out.println(form.toString());
        }
        
        for (Form form: forms) {
//            if (form instanceof Circle) {
//                ((Circle) form).printCircleDimensions();
//            } else if (form instanceof Triangle) {
//                ((Triangle) form).printTriangleDimensions();
//            }
            form.print();
        }
    }
}
