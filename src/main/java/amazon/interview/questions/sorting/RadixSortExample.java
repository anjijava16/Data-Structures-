package amazon.interview.questions.sorting;

/**
 * Created by govind.bhone on 5/16/2017.
 */

import java.util.Scanner;

public class RadixSortExample {
    static void radixSort(int[] a) {
        int i, m = a[0], exp = 1, n = a.length;
        int[] b = new int[a.length];

        for (i = 1; i < n; i++)
            if (a[i] > m)
                m = a[i];

        while (m / exp > 0) {
            int[] bucket = new int[10];

            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;

            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];

            for (i = n - 1; i >= 0; i--) {
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }


            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;
        }
    }

    public static void main(String[] args) {
        int[] x = {100, 6, 75, 4, 5/*, 1,67,78,90,67,89,45,23*/};

        System.out.println("Element before sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        radixSort(x);

        System.out.println("\nElement after sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}