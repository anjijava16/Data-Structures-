package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class BubbleSortExample {

    public static void swap(int[] x, int i, int j) {
        int tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public static void bubbleSort(int [] x ){
        int length = x.length;
        for(int i=0;i<length;i++){
            for(int j=0;j<length-1-i;j++){
                if(x[j] > x[j+1]){
                    swap(x,j,j+1);
                }
            }
        }
    }


    public static void main(String args[]) {
        int[] x = {10, 6, 7, 4, 5, 1};

        System.out.println("Element before sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
        bubbleSort(x);

        System.out.println("\nElement after sorted :");
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i] + " ");
        }
    }
}
