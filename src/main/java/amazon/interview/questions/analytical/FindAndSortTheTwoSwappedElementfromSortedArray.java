package amazon.interview.questions.analytical;

/**
 * Created by govind.bhone on 5/22/2017.
 */
public class FindAndSortTheTwoSwappedElementfromSortedArray {

    public static void sortSwappedElement(int[] x) {
        int n = x.length;
        int s = 0;
        int e = 0;

        //find first element
        for (int i = 0; i < n-1; i++) {
            if (x[i] > x[i + 1]) {
                s = i;
                break;
            }
        }

        if (s == 0) {
            System.out.println("it is already sorted ");
        }

        //find second element
        for (int j = n - 1; j > 0; j--) {
            if (x[j] < x[j - 1]) {
                e = j;
                break;
            }
        }

        //swap these element
        int tmp = x[s];
        x[s] = x[e];
        x[e] = tmp;

    }

    public static void main(String args[]) {
        int[] arr = {10, 20, 40, 30, 50, 60};

        int[] arr1 = {10, 20, 30, 40, 50, 60};

        int [] arr2 ={11,45,23,33,22,89};
        for (int i : arr)
            System.out.print(i + " ");

        System.out.print("\n");

        sortSwappedElement(arr);

        for (int i : arr)
            System.out.print(i + " ");

        sortSwappedElement(arr1);

        sortSwappedElement(arr2);
        for (int i : arr2)
            System.out.print(i + " ");

    }
}
