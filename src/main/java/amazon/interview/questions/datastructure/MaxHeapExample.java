package amazon.interview.questions.datastructure;

public class MaxHeapExample {
    public static void main(String args[]){
        MaxHeap max = new MaxHeap();
        max.add(3);
        max.add(2);
        max.add(4);
        max.add(1);

        System.out.println(max.capacity);
        System.out.println(max.peek());
        System.out.println(max.poll());
        System.out.println(max.poll());

    }
}
