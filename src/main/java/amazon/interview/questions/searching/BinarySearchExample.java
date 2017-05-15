package amazon.interview.questions.searching;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class BinarySearchExample {


    public static int recursiveBinarySearchhelper(int[] x, int y, int l, int r) {
        if (l <= r) {
            int mid = l + (r-l) / 2;
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

    public static int nonRecursiveBinarySearch(int[] x, int y) {
        int l = 0;
        int r = x.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            // Check if x is present at mid
            if (x[m] == y)
                return m;

            // If x greater, ignore left half
            if (x[m] < y)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        // if we reach here, then element was not present
        return -1;
    }

    public static void main(String args[]) {
        int[] x = {10, 20, 30, 40, 50, 60};
        System.out.println(nonRecursiveBinarySearch(x, 40));
        System.out.println(nonRecursiveBinarySearch(x, 30));
        System.out.println(nonRecursiveBinarySearch(x, 60));
        System.out.println(nonRecursiveBinarySearch(x, 10));
        System.out.println(nonRecursiveBinarySearch(x, 100));

        System.out.println(recursiveBinarySearch(x, 40));
        System.out.println(recursiveBinarySearch(x, 30));
        System.out.println(recursiveBinarySearch(x, 60));
        System.out.println(recursiveBinarySearch(x, 10));
        System.out.println(recursiveBinarySearch(x, 100));
    }
}
