package summable;

import java.util.Scanner;

class MyMatrix implements Summable {
    private int[][] m;

    MyMatrix() {
        m = new int[4][4];
    }

    void readData(Scanner scanner) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                m[i][j] = scanner.nextInt();
            }
        }
    }

    void printElems() {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    @Override
    public void addValue(Summable value) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                m[i][j] += ((MyMatrix)value).m[i][j];
            }
        }
    }
}
