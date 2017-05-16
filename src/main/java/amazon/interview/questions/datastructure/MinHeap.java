package amazon.interview.questions.datastructure;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class MinHeap extends Heap {
    @Override
    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[smallerChildIndex] > items[index]) {
                break;
            } else {
                swap(smallerChildIndex, index);
            }
            smallerChildIndex = index;
        }
    }

    @Override
    protected void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }
}
