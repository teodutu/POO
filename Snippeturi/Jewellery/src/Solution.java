import javax.swing.*;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Jewelry {
    int carats;

    Jewelry() {}

    Jewelry(int c) {
        carats = c;
    }

    int price() {
        return carats * 4500;
    }
}

class Necklace extends Jewelry {
    Necklace(int c) {
        super(c);
    }
}

class Bracelet extends Jewelry {
    Bracelet(int c) {
        super(c);
    }
}

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int necklaceCarats = sc.nextInt();
        int braceletCarats = sc.nextInt();
        int totalCost = new Necklace(necklaceCarats).price() + new Bracelet(braceletCarats).price();

        System.out.println("$" + totalCost);
    }
}