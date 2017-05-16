package amazon.interview.questions.datastructure;

import java.util.Scanner;

/**
 * Created by govind.bhone on 5/16/2017.
 */

class Node {
    protected int data;
    protected Node link;

    public Node() {
        link = null;
        data = 0;
    }

    public Node(int d, Node n) {
        data = d;
        link = n;
    }

    public void setLink(Node n) {
        link = n;
    }

    public void setData(int d) {
        data = d;
    }

    public Node getLink() {
        return link;
    }

    public int getData() {
        return data;
    }

    public String toString() {
        return data + " ";
    }
}

public class LinkedListExample {
    protected Node start;
    protected Node end;
    public int size;

    public LinkedListExample() {
        start = null;
        end = null;
        size = 0;
    }

    public boolean isEmpty() {
        return start == null;
    }

    public int getSize() {
        return size;
    }

    public void insertAtStart(int value) {
        Node node = new Node(value, null);
        if (start == null) {
            start = node;
            end = start;
        } else {
            node.setLink(start);
            start = node;
        }
        size++;
    }

    public void insertAtEnd(int value) {
        Node node = new Node(value, null);
        if (start == null) {
            start = node;
            end = start;
        } else {
            end.setLink(node);
            end = node;
        }
        size++;
    }

    public void insertAtPos(int value, int pos) {
        Node node = new Node(value, null);
        int index = 1;
        Node ptr = start;

        while (ptr.link != null && index < pos - 1) {
            ptr = ptr.link;
            index++;
        }
        node.setLink(ptr.link);
        ptr.setLink(node);
        size++;
    }

    public void deleteAtPos(int pos) {
        if (pos == 1) {
            start = start.getLink();
            size--;
            return;
        }
        if (pos == size) {
            Node s = start;
            Node t = start;
            while (s != end) {
                t = s;
                s = s.getLink();
            }
            end = t;
            end.setLink(null);
            size--;
            return;
        }
        int index = 1;
        Node ptr = start;

        while (ptr.link != null && index < pos - 1) {
            ptr = ptr.link;
            index++;
        }
        ptr.setLink(ptr.link.link);
        size--;
    }

    public boolean isCycle() {
        if (start == null) return false;

        // Rabbit tortoise problem
        Node tortoise = start;
        Node rabbit = start.getLink();
        while (tortoise != rabbit) {
            if (rabbit == null || rabbit.getLink() == null) return false;
            tortoise = tortoise.getLink();
            rabbit = rabbit.getLink().getLink();
        }
        return true;
    }

    public void display() {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) {
            System.out.print("empty\n");
            return;
        }
        if (start.getLink() == null) {
            System.out.println(start.getData());
            return;
        }
        Node ptr = start;
        System.out.print(start.getData() + "->");
        ptr = start.getLink();
        while (ptr.getLink() != null) {
            System.out.print(ptr.getData() + "->");
            ptr = ptr.getLink();
        }
        System.out.print(ptr.getData() + "\n");
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        LinkedListExample list = new LinkedListExample();
        System.out.println("Singly Linked List Test\n");
        char ch;
        /*  Perform list operations  */
        do {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.insertAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert");
                    list.insertAtEnd(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt();
                    System.out.println("Enter position");
                    int pos = scan.nextInt();
                    if (pos <= 1 || pos > list.getSize())
                        System.out.println("Invalid position\n");
                    else
                        list.insertAtPos(num, pos);
                    break;
                case 4:
                    System.out.println("Enter position");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.getSize())
                        System.out.println("Invalid position\n");
                    else
                        list.deleteAtPos(p);
                    break;
                case 5:
                    System.out.println("Empty status = " + list.isEmpty());
                    break;
                case 6:
                    System.out.println("Size = " + list.getSize() + " \n");
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);
        } while (ch == 'Y' || ch == 'y');
    }
}
