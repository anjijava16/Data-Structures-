package amazon.interview.questions.sorting;

/**
 * Created by govind.bhone on 5/16/2017.
 */
public class CoutingSortExample {

    public static void countingSort(int[] x) {
        int n = x.length;

        int[] output = new int[n];

        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            ++count[x[i]];

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output character array
        for (int i = n-1; i >=0; i--) {
            output[--count[x[i]]] = x[i];
        }

        // Copy the output array to arr, so that arr now
        // contains sorted characters
        for (int i = 0; i < n; ++i)
            x[i] = output[i];

    }

    public static void main(String args[]) {
        int[] x = {9, 6, 5, 4, 5,6,7};

        System.out.println("Element before sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        countingSort(x);

        System.out.println("\nElement after sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
