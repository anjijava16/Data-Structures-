package amazon.interview.questions.datastructure;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by govind.bhone on 5/16/2017.
 */

class MyEntry<K, V> {
    private final K key;
    private V value;

    public MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}

class MyMap<K, V> {
    private int size;
    private int DEFAULT_CAPACITY = 16;
    @SuppressWarnings("unchecked")
    private MyEntry<K, V>[] values = new MyEntry[DEFAULT_CAPACITY];


    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i] != null) {
                if (values[i].getKey().equals(key)) {
                    return values[i].getValue();
                }
            }
        }
        return null;
    }

    public void put(K key, V value) {
        boolean insert = true;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i].setValue(value);
                insert = false;
            }
        }
        if (insert) {
            ensureCapa();
            values[size++] = new MyEntry<K, V>(key, value);
        }
    }

    private void ensureCapa() {
        if (size == values.length) {
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    public int size() {
        return size;
    }

    public void remove(K key) {
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i] = null;
                size--;
                condenseArray(i);
            }
        }
    }

    private void condenseArray(int start) {
        for (int i = start; i < size; i++) {
            values[i] = values[i + 1];
        }
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (int i = 0; i < size; i++) {
            set.add(values[i].getKey());
        }
        return set;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Map(");
        for(int i=0;i<size;i++ ){
            if(i==size-1){
                sb.append(values[i].getKey()+"->"+values[i].getValue());
            }else {
                sb.append(values[i].getKey()+"->"+values[i].getValue()+",");
            }
        }
        sb.append(")");
        return sb.toString();
    }
}

public class MapExample {
    public static void main(String args[]) {
        MyMap<String, Integer> map = new MyMap<>();
        map.put("a", 10);
        map.put("b", 20);
        map.put("a", 30);
        map.put("d", 80);
        map.remove("b");
        System.out.println(map);
    }
}
