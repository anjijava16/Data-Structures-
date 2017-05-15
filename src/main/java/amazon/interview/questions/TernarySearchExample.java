package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class TernarySearchExample {

    // A recursive ternary search function. It returns location of x in
    // given array arr[l..r] is present, otherwise -1
    static int ternarySearchLoop(int arr[], int l, int r, int x)
    {
        if (r >= l)
        {
            int mid1 = l + (r - l)/3;
            int mid2 = mid1 + (r - l)/3;

            // If x is present at the mid1
            if (arr[mid1] == x)  return mid1;

            // If x is present at the mid2
            if (arr[mid2] == x)  return mid2;

            // If x is present in left one-third
            if (arr[mid1] > x) return ternarySearchLoop(arr, l, mid1-1, x);

            // If x is present in right one-third
            if (arr[mid2] < x) return ternarySearchLoop(arr, mid2+1, r, x);

            // If x is present in middle one-third
            System.out.println("Unreachable statement most of the cases");
            return ternarySearchLoop(arr, mid1+1, mid2-1, x);
        }
        // We reach here when element is not present in array
        return -1;
    }

    static int ternarySearch(int [] x , int y ){
        return ternarySearchLoop(x,0,x.length-1,y);
    }

    public static void main(String args[]){
        int[] x = {10, 20, 30, 40, 50, 60};
        System.out.println(ternarySearch(x, 40));
        System.out.println(ternarySearch(x, 30));
        System.out.println(ternarySearch(x, 60));
        System.out.println(ternarySearch(x, 10));
        System.out.println(ternarySearch(x, 100));

    }
}
