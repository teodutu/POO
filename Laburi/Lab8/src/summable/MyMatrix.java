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

    @Override
    public String toString() {
        String str = "";

        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                str += m[i][j] + " ";
            }
            str += "\n";
        }

        return str.substring(0, str.length() - 1);
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
