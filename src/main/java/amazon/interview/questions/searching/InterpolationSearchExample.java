package amazon.interview.questions.searching;

/**
 * Created by govind.bhone on 5/15/2017.
 */

/*
interpolation search may go to different locations according the value of key being searched.
For example if the value of key is closer to the last element, interpolation search is likely
to start search toward the end side.

To find the position to be searched, it uses following formula.

// The idea of formula is to return higher value of pos
// when element to be searched is closer to arr[hi]. And
// smaller value when closer to arr[lo]
pos = lo + [ (x-arr[lo])*(hi-lo) / (arr[hi]-arr[Lo]) ]

arr[] ==> Array where elements need to be searched
x     ==> Element to be searched
lo    ==> Starting index in arr[]
hi    ==> Ending index in arr[]

 */
public class InterpolationSearchExample {

    public static int interpolationSearch(int[] x, int y) {
        int lo = 0;
        int hi = x.length - 1;

        // Since array is sorted, an element present
        // in array must be in range defined by corner
        while (lo <= hi && y >= x[lo] && y <= x[hi]) {
            // Probing the position with keeping
            // uniform distribution in mind.
            int pos = lo + ((y-x[lo])*(hi-lo) / (x[hi]-x[lo]));

            // Condition of target found
            if (x[pos] == y)
                return pos;

            // If x is larger, x is in upper part
            if (x[pos] < y)
                lo = pos + 1;
            // If x is smaller, x is in lower part
            else
                hi = pos - 1;
        }
        return -1;
    }

    public static void main(String args[]){
        int arr[] = {11, 12, 13, 16, 18, 19, 20, 21, 22, 23,
                24, 33, 35, 42, 47};

        System.out.println(interpolationSearch(arr, 18));
        System.out.println(interpolationSearch(arr, 11));
        System.out.println(interpolationSearch(arr, 47));
        System.out.println(interpolationSearch(arr, 180));
    }
}
