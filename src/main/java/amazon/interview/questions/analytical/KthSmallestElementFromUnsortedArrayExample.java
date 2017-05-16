package amazon.interview.questions.analytical;

import amazon.interview.questions.datastructure.MinHeap;

/**
 * Created by govind.bhone on 5/16/2017.
 */
public class KthSmallestElementFromUnsortedArrayExample {

    public static int sortKthSmallestElement(int[] x, int k) {
        MinHeap min = new MinHeap();
        int count = 0;
        int kthElement = 0;

        //build min heap
        for (int i = 0; i < x.length; i++) {
            min.add(x[i]);
        }

        while (count < k) {
            kthElement = min.poll();
            count++;
        }
        return kthElement;
    }

    public static void main(String args[]) {
        int[] arr = {7, 10, 4, 3, 20, 15};
        System.out.println(sortKthSmallestElement(arr, 3));
    }

}
