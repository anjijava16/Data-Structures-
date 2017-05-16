package amazon.interview.questions.datastructure;

public class MinHeapExample {
    public static void main(String args[]) {
        MinHeap min = new MinHeap();
        min.add(3);
        min.add(2);
        min.add(1);
        min.add(4);
        System.out.println(min.peek());
        System.out.println(min.poll());
        System.out.println(min.poll());
    }
}