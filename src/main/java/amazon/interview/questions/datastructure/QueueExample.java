package amazon.interview.questions.datastructure;

/**
 * Created by govind.bhone on 5/16/2017.
 */
public class QueueExample {

    private static class Node {
        int data;
        Node next;

        private Node(int data) {
            this.data = data;
        }
    }

    private Node front;

    public void enqueue(int data) {
        Node newNode = new Node(data);
        if (front == null) {
            front = newNode;
        }
        front.next = newNode;
    }

    public int pop() {
        if (front == null) return -1;
        int data = front.data;
        front = front.next;
        return data;
    }

    public static void main(String args[]) {
        QueueExample queue = new QueueExample();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(40);
        System.out.println(queue.front.data);
        queue.pop();
        System.out.println(queue.front.data);
    }
}