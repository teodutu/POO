import java.io.*;
import java.util.*;

class Prajitura {
    int quantity;

    Prajitura(int q) {
        quantity = q;
    }

    public String price() {
        return "10RON";
    }
}

class Negresa extends Prajitura {
    Negresa(int q) {
        super(q);
    }

    @Override
    public String price() {
        if (quantity % 10 != 0) {
            return (float) quantity / 10 + "RON";
        }

        return quantity / 10 + "RON";
    }
}

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        System.out.println(new Negresa(sc.nextInt()).price());
    }
}