package hashmap;

import java.util.Scanner;

public class MainHashMap {
    public static void main(String[] args) {
        MyHashMap<String, Double> hashMap = new MyHashMap<>(10);

        hashMap.put("gigi", 2.6);
        hashMap.put("gogu", 3.9);
        hashMap.put("gigi", 4.5);
        hashMap.put("dorel", 1.1);
        hashMap.put("gigel", 2.3);
        hashMap.put("gigica", 5.3);

        Scanner scan = new Scanner(System.in);
        System.out.println(hashMap.get(scan.nextLine()));

        for (MyMapEntry<String, Double> currEntry : hashMap) {
            System.out.println(currEntry.getKey() + " " + currEntry.getValue());
        }
    }
}
