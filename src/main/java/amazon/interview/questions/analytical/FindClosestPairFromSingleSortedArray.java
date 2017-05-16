package amazon.interview.questions.analytical;

/**
 * Created by govind.bhone on 5/16/2017.
 */
/*
Given a sorted array and a number x, find the pair in array whose sum is closest to x
Given a sorted array and a number x, find a pair in array whose sum is closest to x.

Examples:

Input: arr[] = {10, 22, 28, 29, 30, 40}, x = 54
Output: 22 and 30

Input: arr[] = {1, 3, 4, 7, 10}, x = 15
Output: 4 and 10

 */
public class FindClosestPairFromSingleSortedArray {

    // Prints the pair with sum cloest to x
    static void printClosest(int arr[], int n, int x) {
        int res_l = 0, res_r = 0;  // To store indexes of result pair

        // Initialize left and right indexes and difference between
        // pair sum and x
        int l = 0, r = n - 1, diff = Integer.MAX_VALUE;

        // While there are elements between l and r
        while (r > l) {
            // Check if this pair is closer than the closest pair so far
            if (Math.abs(arr[l] + arr[r] - x) < diff) {
                res_l = l;
                res_r = r;
                diff = Math.abs(arr[l] + arr[r] - x);
            }

            // If this pair has more sum, move to smaller values.
            if (arr[l] + arr[r] > x)
                r--;
            else // Move to larger values
                l++;
        }

        System.out.println(" The closest pair is " + arr[res_l] + " and " + arr[res_r]);
    }


    // Driver program to test above function
    public static void main(String[] args) {
        int arr[] = {10, 22, 28, 29, 30, 40}, x = 54;
        int n = arr.length;
        printClosest(arr, n, x);
    }
}
