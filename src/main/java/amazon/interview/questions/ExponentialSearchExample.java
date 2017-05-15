package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class ExponentialSearchExample {

    public static int exponentialSearch(int arr[], int n, int x) {
        // If x is present at firt location itself
        if (arr[0] == x)
            return 0;

        // Find range for binary search by
        // repeated doubling
        int i = 1;
        while (i <= n && arr[i] <= x)
            i = i * 2;

        return BinarySearchExample.recursiveBinarySearchhelper(arr, x, i / 2, Math.min(i, n));
    }

    public static void main(String args[]) {
        int arr[] = {2, 3, 4, 10, 40};

        System.out.println(exponentialSearch(arr,arr.length-1,10));
        System.out.println(exponentialSearch(arr,arr.length-1,2));
        System.out.println(exponentialSearch(arr,arr.length-1,40));
        System.out.println(exponentialSearch(arr,arr.length-1,9));
    }
}
