package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/15/2017.
 */
public class LinearSearchExample {
    private static int searchRecursive(int[] x, int y, int index) {
        if (index < 0 || index >= x.length) {
            return -1;
        } else {
            if (x[index] == y) return index;
            else return searchRecursive(x, y, index+=1);
        }
    }

    static int search(int[] x, int y) {
        return searchRecursive(x, y, 0);
    }

    static int nonRecursiveSearch(int [] x , int y){
        for(int i=0;i<x.length;i++){
            if(x[i]==y)return i ;
        }
        return -1;
    }

    public static void main(String args[]) {
        int[] x = {4, 5, 6, 7, 8, 9, 10};
        System.out.println(search(x, 4));
        System.out.println(nonRecursiveSearch(x, 4));
        System.out.println(search(x, 10));
        System.out.println(nonRecursiveSearch(x, 10));
        System.out.println(search(x, 40));
        System.out.println(nonRecursiveSearch(x, 40));
    }
}
