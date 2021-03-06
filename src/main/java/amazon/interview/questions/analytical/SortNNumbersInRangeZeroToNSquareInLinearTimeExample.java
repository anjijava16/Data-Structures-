package amazon.interview.questions.analytical;

/**
 * Created by govind.bhone on 5/16/2017.
 */
public class SortNNumbersInRangeZeroToNSquareInLinearTimeExample {

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i, count[] = new int[n];
        for (i = 0; i < n; i++)
            count[i] = 0;

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % n]++;

        // Change count[i] so that count[i] now contains actual
        // position of this digit in output[]
        for (i = 1; i < n; i++)
            count[i] += count[i - 1];

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[--count[(arr[i] / exp) % n]] = arr[i];
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }


    // The main function to that sorts arr[] of size n using Radix Sort
    public static void sort(int arr[], int n) {
        // Do counting sort for first digit in base n. Note that
        // instead of passing digit number, exp (n^0 = 0) is passed.
//        countSort(arr, n, 1);

        // Do counting sort for second digit in base n. Note that
        // instead of passing digit number, exp (n^1 = n) is passed.
        countSort(arr, n, n);
    }

    // A utility function to print an array
    public static void printArr(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }


    public static void main(String args[]) {
        int arr[] = {40, 12, 45, 32, 33, 1, 22};
        int n = arr.length;
        System.out.println("Given array");
        printArr(arr, n);

        sort(arr, n);

        System.out.println("\nSorted array");
        printArr(arr, n);
    }
}
