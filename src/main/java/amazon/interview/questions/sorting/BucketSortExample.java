package amazon.interview.questions.sorting;

import java.util.Arrays;

/**
 * Created by govind.bhone on 5/16/2017.
 */
public class BucketSortExample {

    public static void bucketSort(int[] a, int maxVal) {
        int[] bucket = new int[maxVal + 1];

        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = 0;
        }

        for (int i = 0; i < a.length; i++) {
            bucket[a[i]]++;
        }

/*
        for(int j=0;j<bucket.length;j++){
            System.out.println(bucket[j]);
        }
*/

        int outPos = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                a[outPos++] = i;
            }
        }
    }

    public static int maxValue(int[] data) {
        int max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] data = {5, 3, 0, 2, 4, 0, 5, 2, 3, 4};

        System.out.println("Before: " + Arrays.toString(data));
        bucketSort(data, maxValue(data));
        System.out.println("After:  " + Arrays.toString(data));
    }
}
