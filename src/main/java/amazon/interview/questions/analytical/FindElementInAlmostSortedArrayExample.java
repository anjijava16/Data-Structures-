package amazon.interview.questions.analytical;

/**
 * Created by govind.bhone on 5/16/2017.
 */

/*
Search in an almost sorted array
Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,
i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.

Example:

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
Output: 2
Output is index of 40 in given array

Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
Output: -1
-1 is returned to indicate element is not present


 */
public class FindElementInAlmostSortedArrayExample {

    // A recursive binary search based function. It returns
// index of x in given array arr[l..r] is present,
// otherwise -1
    public static int binarySearch(int arr[], int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present at one of the middle
            // 3 positions
            if (arr[mid] == x) return mid;
            if (mid > l && arr[mid - 1] == x) return (mid - 1);
            if (mid < r && arr[mid + 1] == x) return (mid + 1);

            // If element is smaller than mid, then it can only
            // be present in left subarray
            if (arr[mid] > x) return binarySearch(arr, l, mid - 2, x);

            // Else the element can only be present in right subarray
            return binarySearch(arr, mid + 2, r, x);
        }

        // We reach here when element is not present in array
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = {3, 2, 10, 4, 40};
        int index =binarySearch(arr,0,arr.length-1,4);
        System.out.println(index);
    }
}
