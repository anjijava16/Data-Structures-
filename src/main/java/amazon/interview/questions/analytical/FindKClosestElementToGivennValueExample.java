package amazon.interview.questions.analytical;

/**
 * Created by govind.bhone on 5/16/2017.
 */
public class FindKClosestElementToGivennValueExample {

    public static int recursiveBinarySearchhelper(int[] x, int y, int l, int r) {
        if (l <= r) {
            int mid = l + (r - l) / 2;
            if (x[mid] == y) return mid;

            if (y > x[mid]) return recursiveBinarySearchhelper(x, y, mid + 1, r);
            else
                return recursiveBinarySearchhelper(x, y, l, mid - 1);

        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] x, int y) {
        return recursiveBinarySearchhelper(x, y, 0, x.length - 1);
    }

    public static void findKClosestElementToGivenValue(int[] x, int y, int k) {
        int l = recursiveBinarySearch(x, y);
        int r = l + 1;
        int count = 0;

        if (x[l] == y) l--;

        System.out.println(l);
        System.out.println(r);
        // Compare elements on left and right of crossover
        // point to find the k closest elements
        while (l >= 0 && r < x.length && count < k) {
            if (y - x[l] < x[r] - y) {
                System.out.println("Element is " + x[l--]);
            } else {
                System.out.println("Element is " + x[r++]);
            }
            count++;
        }

        //what if r value reaches to maximum
        while (count < k && l >= 0) {
            System.out.println("Element is " + x[l--]);
            count++;
        }

        //what if l value reaches to lower bound
        while (count < k && r < x.length) {
            System.out.println("Element is " + x[r++]);
            count++;
        }

    }

    public static void main(String args[]) {
        int[] arr = {12, 16, 22, 30, 35, 39, 42,
                45, 48, 50, 53, 55, 56};
        findKClosestElementToGivenValue(arr, 35, 4);
    }
}
