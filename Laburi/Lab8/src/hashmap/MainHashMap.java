package hashmap;

import java.util.Scanner;

public class MainHashMap {
    public static void main(String[] args) {
        MyHashMap<MyString, Double> hashMap = new MyHashMap<>(10);

        hashMap.put(new MyString("gigi"), 2.6);
        hashMap.put(new MyString("gigi"), 4.5);
        hashMap.put(new MyString("gogu"), 3.9);
        hashMap.put(new MyString("dorel"), 1.1);
        hashMap.put(new MyString("gigel"), 2.3);
        hashMap.put(new MyString("gigica"), 5.3);

        Scanner scan = new Scanner(System.in);
        System.out.println(hashMap.get(new MyString(scan.nextLine())));

        for (MyMapEntry<MyString, Double> currEntry : hashMap) {
            System.out.println(currEntry.getKey() + " " + currEntry.getValue());
        }
    }
}
