package amazon.interview.questions.analytical;

/**
 * Created by govind.bhone on 5/16/2017.
 */

/*

Find the Minimum length Unsorted Subarray, sorting which makes the complete array sorted
Given an unsorted array arr[0..n-1] of size n, find the minimum length subarray arr[s..e] such that
sorting this subarray makes the whole array sorted.

Examples:
1) If the input array is [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60], your program should be able to
find that the subarray lies between the indexes 3 and 8.

2) If the input array is [0, 1, 15, 25, 6, 7, 30, 40, 50], your program should be able to find that the
subarray lies between the indexes 2 and 5.

 */
public class FindTheMinimumLengthSubArraySortingExample {

    public static void findMinimumLengthUnsortedSubArray(int[] x) {
        int length = x.length;
        int s = 0;
        int e = length - 1;

        //finding start point
        for (int i = 0; i < length - 1; i++) {
            if (x[i] > x[i + 1]) {
                s = i;
                break;
            }
        }


        if (s == 0) {
            System.out.println("Array is already sorted ");
            System.exit(0);
        }


        //finding end point
        for (int j = length - 1 ; j > 0; j--) {
            if (x[j] < x[j - 1]) {
                e = j;
                break;
            }
        }

        //finding the minimum and maximum from selected subarray
        int min = x[s], max = x[s];
        for (int i = s + 1; i <= e; i++) {
            if (x[i] < min) {
                min = x[i];
            }
            if (x[i] > max) {
                max = x[i];
            }
        }

        for (int i = 0; i < s; i++) {
            if (x[i] > min) {
                s = i;
                break;
            }
        }

        for (int i = length - 1; i >= e + 1; i--) {
            if (x[i] < max) {
                e = i;
                break;
            }
        }
        System.out.println("Array which is unsorted start with index "+s+" and ends with index "+e);
    }

    public static void main(String args[]) {
        int arr[] = {10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60};

        findMinimumLengthUnsortedSubArray(arr);

        int arr1[] = {10, 12, 20, 30};
        findMinimumLengthUnsortedSubArray(arr1);
    }
}
