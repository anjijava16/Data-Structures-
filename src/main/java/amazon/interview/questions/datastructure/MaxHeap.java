package amazon.interview.questions.datastructure;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class MaxHeap extends Heap {
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
