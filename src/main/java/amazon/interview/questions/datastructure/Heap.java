package amazon.interview.questions.datastructure;

import java.util.Arrays;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public abstract class Heap {
    /**
     * Current array length
     **/
    protected int capacity;
    /**
     * Current number of elements in Heap
     **/
    protected int size;
    /**
     * Array of Heap elements
     **/
    protected int[] items;

    public Heap() {
        this.capacity = 10;
        this.size = 0;
        this.items = new int[capacity];
    }

    protected int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    protected int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    protected int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    protected boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    protected boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    protected boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    protected int getLeftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    protected int getRightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    protected int getParent(int index) {
        return items[getParentIndex(index)];
    }

    protected void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    protected void ensureCapacity() {
        if (size == capacity) {
            capacity = capacity << 1;
            items = Arrays.copyOf(items, capacity);
        }
    }

    protected void isEmpty(String methodName) {
        if (size == 0) {
            throw new IllegalStateException(
                    "You cannot perform '" + methodName + "' on an empty Heap."
            );
        }
    }

    public int peek() {
        isEmpty("peek");
        return items[0];
    }

    public int poll() {
        isEmpty("poll");
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }


    public void add(int item) {
        ensureCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    protected abstract void heapifyDown();
    protected abstract void heapifyUp();
}
