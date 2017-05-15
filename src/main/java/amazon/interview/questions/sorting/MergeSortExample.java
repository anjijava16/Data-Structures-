package amazon.interview.questions.sorting;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class MergeSortExample {

    public static void merge(int[] x, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = x[l + i];
        }

        for (int j = 0; j < n2; j++) {
            R[j] = x[m + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                x[k] = L[i];
                i++;
            } else {
                x[k] = R[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1) {
            x[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2) {
            x[k] = R[j];
            j++;
            k++;
        }

    }

    public static void mergeSortLoop(int[] x, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSortLoop(x, l, m);
            mergeSortLoop(x, m + 1, r);
            merge(x, l, m, r);
        }
    }

    public static void mergeSort(int[] x) {
        mergeSortLoop(x, 0, x.length - 1);
    }

    public static void main(String args[]) {
        int[] x = {10, 6, 7, 4, 5, 1};

        System.out.println("Element before sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        mergeSort(x);

        System.out.println("\nElement after sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
