package hashmap;

class MyMapEntry<K, V> {
    private K key;
    private V value;

    MyMapEntry(K newKey, V newVal) {
        key = newKey;
        value = newVal;
    }

    K getKey() {
        return key;
    }

    V getValue() {
        return value;
    }

    void setValue(V newVal) {
        value = newVal;
    }
}
