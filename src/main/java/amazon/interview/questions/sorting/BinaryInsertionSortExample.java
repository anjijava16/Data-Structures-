package amazon.interview.questions.sorting;

/**
 * Created by govind.bhone on 5/22/2017.
 */
public class BinaryInsertionSortExample {

    public static int binarySearch(int[] x, int item, int low, int high) {
        if (high <= low) {
            return (item > x[low]) ? (low + 1) : low;
        }

        int mid = (low + high) / 2;

        if (item == x[mid])
            return mid + 1;

        if (item > x[mid])
            return binarySearch(x, item, mid + 1, high);
        return binarySearch(x, item, low, mid - 1);
    }

    public static void binaryInsertionSort(int[] x) {
        int length = x.length;

        for (int i = 1; i < length; i++) {
            int j = i - 1;
            int selected = x[i];

            int loc = binarySearch(x, selected, 0, j);
            while (j >= loc) {
                x[j + 1] = x[j];
                j--;
            }
            x[j + 1] = selected;
        }
    }

    public static void main(String args[]) {
        int[] x = {10, 30, 23, 45, 33, 67};
        binaryInsertionSort(x);

        for(int i:x){
            System.out.println(i);
        }

    }
}
