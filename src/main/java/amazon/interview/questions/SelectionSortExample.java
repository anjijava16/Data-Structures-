package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/15/2017.
 */
/*
The selection sort algorithm sorts an array by repeatedly finding the minimum element (considering ascending order)
from unsorted part and putting it at the beginning. The algorithm maintains two subarrays in a given array.

 */
public class SelectionSortExample {

    public static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static void selectionSort(int[] x) {
        int length = x.length;
        for (int i = 0; i < length; i++) {
            int min_index = i;
            for (int j = i + 1; j < length; j++) {
                if (x[min_index] > x[j]) min_index = j;
            }

            //swapping two elements
            swap(x, min_index, i);
        }
    }

    public static void main(String args[]) {
        int[] x = {10, 6, 7, 4, 5, 1};

        System.out.println("Element before sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        selectionSort(x);

        System.out.println("\nElement after sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
