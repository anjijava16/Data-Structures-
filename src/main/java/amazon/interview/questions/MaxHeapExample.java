package amazon.interview.questions;

import java.util.Collections;

/**
 * Created by govind.bhone on 5/15/2017.
 */
class MaxHeap extends Heap {
    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) > getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] > items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    protected void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) < items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}

public class MaxHeapExample {
    public static void main(String args[]){
        MaxHeap max = new MaxHeap();
        max.add(3);
        max.add(2);
        max.add(4);
        max.add(1);

        System.out.println(max.capacity);
        System.out.println(max.peek());
        System.out.println(max.poll());
        System.out.println(max.poll());

    }
}
