package hashmap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class MyHashMap<K, V> implements Iterable<MyMapEntry<K, V>> {
    private static final double QUOTIENT = 0.7;
    private ArrayList<LinkedList<MyMapEntry<K, V>>> mapArr;

    MyHashMap(int maxElems) {
        mapArr = new ArrayList<>();
        int size = (int)(maxElems / QUOTIENT);

        for (int i = 0; i < size; ++i) {
            mapArr.add(new LinkedList<>());
        }
    }

    private MyMapEntry<K, V> findKey(K key) {
        for (MyMapEntry<K, V> currEntry : mapArr.get(Math.abs(key.hashCode()) % mapArr.size())) {
            if (currEntry.getKey().equals(key)) {
                return currEntry;
            }
        }

        return null;
    }

     void put(K key, V value) {
        MyMapEntry<K, V> currEntry = findKey(key);

        if (currEntry == null) {
            mapArr.get(Math.abs(key.hashCode()) % mapArr.size()).add(new MyMapEntry<>(key, value));
        } else {
            currEntry.setValue(value);
        }
     }

     V get(K key) {
         MyMapEntry<K, V> currEntry = findKey(key);

         if (currEntry != null) {
             return currEntry.getValue();
         } else {
             return null;
         }
     }

    @Override
    public Iterator<MyMapEntry<K, V>> iterator() {
        return new Iterator<>() {
            Iterator<LinkedList<MyMapEntry<K, V>>> arrayListIterator = mapArr.iterator();
            Iterator<MyMapEntry<K, V>> listIterator;

            @Override
            public boolean hasNext() {
                if (listIterator != null && listIterator.hasNext()) {
                    return true;
                } else {
                    while (arrayListIterator.hasNext()) {
                        listIterator = arrayListIterator.next().iterator();
                        if (listIterator.hasNext()) {
                            return true;
                        }
                    }

                    return false;
                }
            }

            @Override
            public MyMapEntry<K, V> next() {
                if (listIterator != null && listIterator.hasNext()) {
                    return listIterator.next();
                } else {
                    while (arrayListIterator.hasNext()) {
                        listIterator = arrayListIterator.next().iterator();
                        if (listIterator.hasNext()) {
                            return listIterator.next();
                        }
                    }
                    return null;
                }
            }
        };
    }
}
