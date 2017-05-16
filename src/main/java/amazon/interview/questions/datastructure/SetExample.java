package amazon.interview.questions.datastructure;

import java.lang.reflect.Array;

/**
 * Created by govind.bhone on 5/17/2017.
 */
class Set<T> {
    private T arrayElement[];
    int size = 0;

    public Set(Class<T> c) {
        this.arrayElement = (T[]) Array.newInstance(c, 10);
    }

    public Set(T[] element) {
        arrayElement = element;
        size = arrayElement.length;
    }

    public void addElement(T element) {
        if (!contains(element)) {
            if (size == arrayElement.length) {
                incrementArray();
            }
            arrayElement[size++] = element;
        }
    }

    public boolean contains(T elem) {
        if (elem == null) {
            for (int i = 0; i < size; i++)
                if (arrayElement[i] == null)
                    return true;
        } else {
            for (int i = 0; i < size; i++)
                if (elem.equals(arrayElement[i]))
                    return true;
        }
        return false;
    }

    public int size() {
        if (arrayElement != null) {
            return arrayElement.length;
        } else
            return 0;
    }

    public void clear() {
        arrayElement = null;
    }


    public String toString() {
        if (arrayElement == null || arrayElement.length == 0) {
            return "[EMPTY]";
        } else {
            String toStr = "[";
            for (int i = 0; i < arrayElement.length; i++) {
                if (i == arrayElement.length - 1) {
                    toStr += arrayElement[i];
                } else {
                    toStr += arrayElement[i] + ",";
                }
            }
            toStr += "]";
            return toStr;
        }
    }

    public boolean isEmpty() {
        if (arrayElement == null || arrayElement.length == 0)
            return true;
        else
            return false;
    }

    private void incrementArray() {
        T[] temparray = arrayElement;
        int tempsize = size + 5;
        arrayElement = (T[]) new Object[tempsize];
        System.arraycopy(temparray, 0, arrayElement, 0, size);

    }
}

public class SetExample {
    public static void main(String args[]) {
        Set<Integer> set = new Set<Integer>(Integer.class);
        set.addElement(10);
        set.addElement(20);
        set.addElement(10);
        System.out.println(set.toString());
    }
}