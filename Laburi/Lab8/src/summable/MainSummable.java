package summable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class MainSummable {
    private static void addAll(Collection<? extends Summable> summable) {
        Iterator<? extends Summable> it = summable.iterator();

        try {
            Summable firstElem = it.next();

            while (it.hasNext()) {
                firstElem.addValue(it.next());
            }
        } catch (NoSuchElementException e) {
            System.out.println("Empty collection!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MyMatrix m1 = new MyMatrix();
        MyMatrix m2 = new MyMatrix();
        MyMatrix m3 = new MyMatrix();

        m1.readData(sc);
        m2.readData(sc);
        m3.readData(sc);

        ArrayList<Summable> summales = new ArrayList<>();
        summales.add(m1);
        summales.add(m2);
        summales.add(m3);

        addAll(summales);
        System.out.println(m1 + "\n");

        MyVector3 v1 = new MyVector3(1, 2, 3);
        MyVector3 v2 = new MyVector3(10, 20, 30);
        MyVector3 v3 = new MyVector3(0, 0, 0);

        summales.clear();
        summales.add(v1);
        summales.add(v2);
        summales.add(v3);

        addAll(summales);
        System.out.println(v1 + "\n");

        summales.clear();
        addAll(summales);
    }
}
