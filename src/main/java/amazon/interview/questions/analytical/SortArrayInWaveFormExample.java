package amazon.interview.questions.analytical;

import java.util.Arrays;

/**
 * Created by govind.bhone on 5/16/2017.
 */

/*

A Simple Solution is to use sorting. First sort the input array, then swap all adjacent elements.

For example, let the input array be {3, 6, 5, 10, 7, 20}. After sorting, we get {3, 5, 6, 7, 10, 20}.
After swapping adjacent elements, we get {5, 3, 7, 6, 20, 10}.

Below are implementations of this simple approach.

 */
public class SortArrayInWaveFormExample {
    // A utility method to swap two numbers.
    public static void swap(int arr[], int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // This function sorts arr[0..n-1] in wave form, i.e.,
    // arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4]..
    public static void sortInWave(int arr[]) {
        // Sort the input array
        Arrays.sort(arr);

        // Swap adjacent elements
        for (int i = 0; i < arr.length - 1; i += 2)
            swap(arr, i, i + 1);
    }

    // Driver method
    public static void main(String args[]) {
        int arr[] = {10, 90, 49, 2, 1, 5, 23};
        int n = arr.length;
        sortInWave(arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
