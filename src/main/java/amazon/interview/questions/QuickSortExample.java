package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class QuickSortExample {

    public static void swap(int[] x, int i, int j) {
        int temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static void quickSortImpl(int[] x, int lower, int upper) {
        int i = lower;
        int j = upper;
        int pivot = x[(lower + upper) / 2];

        while (i <= j) {
            while (x[i] < pivot) {
                i++;
            }
            while (x[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(x, i, j);
                i++;
                j--;
            }
        }
        if (lower < j) {
            quickSortImpl(x, lower, j);
        }
        if (i < upper) {
            quickSortImpl(x, i, upper);
        }
    }

    public static void quickSort(int[] x) {
        quickSortImpl(x, 0, x.length - 1);
    }

    public static void main(String args[]) {
        int[] x = {10, 6, 7, 4, 5, 1};

        System.out.println("Element before sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        quickSort(x);

        System.out.println("\nElement after sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
