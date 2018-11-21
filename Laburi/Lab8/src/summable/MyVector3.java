package summable;

public class MyVector3 implements Summable {
    private int[] arr;

    MyVector3(int t1, int t2, int t3) {
        arr = new int[3];

        arr[0] = t1;
        arr[1] = t2;
        arr[2] = t3;
    }

    void printElems() {
        for (int i = 0; i < 3; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    @Override
    public void addValue(Summable value) {
        for (int i = 0; i < 3; ++i) {
            arr[i] += ((MyVector3)value).arr[i];
        }
    }
}
