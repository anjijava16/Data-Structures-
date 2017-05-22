package amazon.interview.questions.sorting;

/**
 * Created by govind.bhone on 5/22/2017.
 */

/*
ShellSort
ShellSort is mainly a variation of Insertion Sort. In insertion sort,
we move elements only one position ahead. When an element has to be moved far ahead,
many movements are involved. The idea of shellSort is to allow exchange of far items.
In shellSort, we make the array h-sorted for a large value of h. We keep reducing the value
of h until it becomes
1. An array is said to be h-sorted if all sublists of every h’th element is sorted.


 */
public class ShellSortExample {

    /* An utility function to print array of size n*/
    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void shellSort(int[] x) {
        int length = x.length;

        for (int gap = length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int temp = x[i];

                int j;
                for (j = i; j >= gap && x[j - gap] > temp; j -= gap) {
                    x[j] = x[j - gap];
                }
                x[j] = temp;

            }
        }

    }

    public static void main(String args[]) {
        int arr[] = {12, 34, 54, 2, 3};
        System.out.println("Array before sorting");
        printArray(arr);
        shellSort(arr);

        System.out.println("Array after sorting");
        printArray(arr);
    }
}
