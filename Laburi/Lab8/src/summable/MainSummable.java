package summable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MainSummable {
    static private void addAll(Collection<? extends Summable> summable, Summable res) {
        for (Summable elem : summable) {
            res.addValue(elem);
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

        ArrayList<Summable> matrices = new ArrayList<>();
        matrices.add(m1);
        matrices.add(m2);

        addAll(matrices, m3);
        m3.printElems();

        MyVector3 v1 = new MyVector3(1, 2, 3);
        MyVector3 v2 = new MyVector3(10, 20, 30);
        MyVector3 v3 = new MyVector3(0, 0, 0);

        matrices.clear();
        matrices.add(v1);
        matrices.add(v2);

        addAll(matrices, v3);
        v3.printElems();
    }
}
