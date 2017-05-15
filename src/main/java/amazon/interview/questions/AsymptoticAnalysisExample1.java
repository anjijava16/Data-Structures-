package amazon.interview.questions;

/**
 * Created by govind.bhone on 5/14/2017.
 */
/*
Asymptotic Analysis is the big idea that handles above issues in analyzing algorithms. In Asymptotic Analysis,
we evaluate the performance of an algorithm in terms of input size (we don’t measure the actual running time).

For example, let us consider the search problem (searching a given item) in a sorted array.
 One way to search is Linear Search (order of growth is linear) and other way is Binary Search (order of growth
 is logarithmic). To understand how Asymptotic Analysis solves the above mentioned problems in analyzing algorithms,
 let us say we run the Linear Search on a fast computer and Binary Search on a slow computer. For small values of input
 array size n, the fast computer may take less time. But, after certain value of input array size, the Binary Search
 will definitely start taking less time compared to the Linear Search even though the Binary Search is being run on a
 slow machine. The reason is the order of growth of Binary Search with respect to input size logarithmic while the order
 of growth of Linear Search
 is linear. So the machine dependent constants can always be ignored after certain values of input size.

 For example, say there are two sorting algorithms that take 1000nLogn and 2nLogn time respectively on a machine.
 Both of these algorithms are asymptotically same (order of growth is nLogn). So, With Asymptotic Analysis,
 we can’t judge which one is better as we ignore constants in Asymptotic Analysis.


worst case analysis :
We must know the case that causes maximum number of operations to be executed.
In worst case complextiy we check for the upper bound of an array , and it is when if element we are searching
not present in array .
so it will search and check for every element so worst case complexity is O(n)

Average case analysis :

Average Case Time = analysis1

                  = analysis2

                  = Θ(n)


Best case analytis :
n the best case analysis, we calculate lower bound on running time of an algorithm.
We must know the case that causes minimum number of operations to be executed. In the linear search problem,
the best case occurs when x is present at the first location.
The number of operations in the best case is constant (not dependent on n). So time complexity in the best case would be Θ(1)

1) O(1) => set of non-recursive and non-loop statements

A loop or recursion that runs a constant number of times is also considered as O(1). For example the following loop is O(1).

   // Here c is a constant
   for (int i = 1; i <= c; i++) {
        // some O(1) expressions
   }

2) O(n): Time Complexity of a loop is considered as O(n) if the loop variables is incremented /
decremented by a constant amount. For example following functions have O(n) time complexity.

   // Here c is a positive integer constant
   for (int i = 1; i <= n; i += c) {
        // some O(1) expressions
   }

   for (int i = n; i > 0; i -= c) {
        // some O(1) expressions
   }

3) O(nc): Time complexity of nested loops is equal to the number of times the innermost
statement is executed. For example the following sample loops have O(n2) time complexity


   for (int i = 1; i <=n; i += c) {
       for (int j = 1; j <=n; j += c) {
          // some O(1) expressions
       }
   }

   for (int i = n; i > 0; i += c) {
       for (int j = i+1; j <=n; j += c) {
          // some O(1) expressions
   }

4) O(Logn) Time Complexity of a loop is considered as O(Logn) if the loop
variables is divided / multiplied by a constant amount.

   for (int i = 1; i <=n; i *= c) {
       // some O(1) expressions
   }
   for (int i = n; i > 0; i /= c) {
       // some O(1) expressions
   }

5) O(LogLogn) Time Complexity of a loop is considered as O(LogLogn) if the loop
variables is reduced / increased exponentially by a constant amount.

   // Here c is a constant greater than 1
   for (int i = 2; i <=n; i = pow(i, c)) {
       // some O(1) expressions
   }
   //Here fun is sqrt or cuberoot or any other constant root
   for (int i = n; i > 0; i = fun(i)) {
       // some O(1) expressions
   }

How to combine time complexities of consecutive loops?
When there are consecutive loops, we calculate time complexity as sum of time complexities of individual loops.

   for (int i = 1; i <=m; i += c) {
        // some O(1) expressions
   }
   for (int i = 1; i <=n; i += c) {
        // some O(1) expressions
   }
   Time complexity of above code is O(m) + O(n) which is O(m+n)
   If m == n, the time complexity becomes O(2n) which is O(n).

How to calculate time complexity when there are many if, else statements inside loops?
As discussed here, worst case time complexity is the most useful among best, average and worst. Therefore we need to consider worst case.
We evaluate the situation when values in if-else conditions cause maximum number of statements to be executed.
For example consider the linear search function where we consider the case when element is present at the end or not present at all.
When the code is too complex to consider all if-else cases, we can get an upper bound by ignoring if else and other complex control statements.
 */




public class AsymptoticAnalysisExample1 {
    public static int search(int[] array, int x) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] == x) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        int[] array = {34, 56, 67, 89, 45, 56, 78};
        System.out.println(search(array,56));
    }
}
