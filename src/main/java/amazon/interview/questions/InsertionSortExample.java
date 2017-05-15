package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/15/2017.
 */
/*
Another Example:
12, 11, 13, 5, 6

Let us loop for i = 1 (second element of the array) to 5 (Size of input array)

i = 1. Since 11 is smaller than 12, move 12 and insert 11 before 12
11, 12, 13, 5, 6

i = 2. 13 will remain at its position as all elements in A[0..I-1] are smaller than 13
11, 12, 13, 5, 6

i = 3. 5 will move to the beginning and all other elements from 11 to 13 will move one position ahead
of their current position.
5, 11, 12, 13, 6

i = 4. 6 will move to position after 5, and elements from 11 to 13 will move one position ahead of their current position.
5, 6, 11, 12, 13

 */
public class InsertionSortExample {
    public static void insertionSort(int[] x) {
        int length = x.length;

        for (int i = 1; i < length; i++) {
            int key = x[i];
            int j = i - 1;

            while (j >= 0 && x[j] > key) {
                x[j + 1] = x[j];
                j -= 1;
            }
            x[j + 1] = key;
        }
    }

    public static void main(String args[]) {
        int[] x = {10, 6, 7, 4, 5, 1};

        System.out.println("Element before sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        insertionSort(x);

        System.out.println("\nElement after sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
