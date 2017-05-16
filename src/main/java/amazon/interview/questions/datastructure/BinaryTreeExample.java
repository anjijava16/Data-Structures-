package amazon.interview.questions.datastructure;

/**
 * Created by govind.bhone on 5/17/2017.
 */

public class BinaryTreeExample {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(Node root, int data) {
        if (root.data > data) {
            if (root.left != null) {
                insert(root.left, data);
            } else {
                root.left = new Node(data);
            }
        } else {
            if (root.right != null) {
                insert(root.right, data);
            } else {
                root.right = new Node(data);
            }
        }
    }

    public boolean find(Node root, int value) {
        if (root.data > value) {
            if (root.left == null)
                return false;
            else
                return find(root.left, value);
        } else if (root.data < value) {
            if (root.right == null)
                return false;
            else
                return find(root.right, value);
        } else {
            return true;
        }
    }

    public void printInOrderRecursion(Node root) {
        if (root.left != null) {
            printInOrderRecursion(root.left);
        }
        System.out.print(root.data + " ");
        if (root.right != null) {
            printInOrderRecursion(root.right);
        }
    }

    public void printPostOrderRecursion(Node root) {
        if (root.left != null) {
            printPostOrderRecursion(root.left);
        }
        if (root.right != null) {
            printPostOrderRecursion(root.right);
        }
        System.out.print(root.data + " ");
    }

    public void printPreOrderRecursion(Node root) {
        System.out.print(root.data + " ");
        if (root.left != null) {
            printPreOrderRecursion(root.left);
        }
        if (root.right != null) {
            printPreOrderRecursion(root.right);
        }
    }

    public void printInOrderIterative(Node root) {
        java.util.Stack<Node> stack = new java.util.Stack<Node>();
        Node node = root;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        while (stack.size() > 0) {
            node = stack.pop();
            System.out.print(node.data + " ");
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
    }

    public void printPreOrderIterative(Node root) {


        Node current = root;
        java.util.Stack<Node> stack = new java.util.Stack<Node>();
        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                System.out.print(current.data + " ");
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    public void printPostOrderIterative(Node root) {
        java.util.Stack<Node> S = new java.util.Stack<Node>();
        // Check for empty tree
        S.push(root);
        Node prev = null;
        while (!S.isEmpty()) {
            Node current = S.peek();

            /* go down the tree in search of a leaf an if so process it
            and pop stack otherwise move down */
            if (prev == null || prev.left == current ||
                    prev.right == current) {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    System.out.print(current.data + " ");
                }

                /* go up the tree from left node, if the child is right
                   push it onto stack otherwise process parent and pop
                   stack */
            } else if (current.left == prev) {
                if (current.right != null)
                    S.push(current.right);
                else {
                    S.pop();
                    System.out.print(current.data + " ");
                }

                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } else if (current.right == prev) {
                S.pop();
                System.out.print(current.data + " ");
            }

            prev = current;
        }

    }

    public void delete(Node root, int k) {
        if (root == null)
            System.out.println("Tree Empty");
        else if (find(root, k) == false)
            System.out.println("Sorry " + k + " is not present");
        else {
            root = deleteNode(root, k);
            System.out.println(k + " deleted from the tree");
        }
    }

    private Node deleteNode(Node root, int k) {
        Node p, p2, n;
        if (root.data == k) {
            Node lt, rt;
            lt = root.left;
            rt = root.right;
            if (lt == null && rt == null)
                return null;
            else if (lt == null) {
                p = rt;
                return p;
            } else if (rt == null) {
                p = lt;
                return p;
            } else {
                p2 = rt;
                p = rt;
                while (p.left != null)
                    p = p.left;
                p.left = lt;
                return p2;
            }
        }
        if (k < root.data) {
            n = deleteNode(root.left, k);
            root.left = n;
        } else {
            n = deleteNode(root.right, k);
            root.right = n;
        }
        return root;
    }


    static void levelOrderTraversal(Node root) {
        //Write your code here
        if (root == null) return;
        java.util.Queue<Node> queue = new java.util.LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            System.out.print(node.data + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
    }

    boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBST(Node node, int min, int max) {
        if (node == null) return true;
        return min < node.data && node.data < max &&
                checkBST(node.left, min, node.data) &&
                checkBST(node.right, node.data, max);
    }

    public void invertTree(Node root) {
        if (root == null) {
            return;
        }

        Node temp = root.right;
        root.right = root.left;
        root.left = temp;

        invertTree(root.left);

        invertTree(root.right);
    }

    public int heightOfBinaryTree(Node node) {
        if (node == null) {
            return -1;
        } else {
            return 1 +
                    Math.max(heightOfBinaryTree(node.left),
                            heightOfBinaryTree(node.right));
        }
    }

    boolean isBalanced(Node node) {
        int BalanceFactor = 1;
        int lh;
        int rh;

        if (node == null)
            return true;

        lh = heightOfBinaryTree(node.left);
        System.out.println("height is" + lh);
        rh = heightOfBinaryTree(node.right);

        if (Math.abs(lh - rh) <= BalanceFactor
                && isBalanced(node.left)
                && isBalanced(node.right))
            return true;
        return false;
    }

    public boolean isEmpty(Node root) {
        return root == null;
    }

    public static void main(String args[]) {
        Node root = new Node(10);

        BinaryTreeExample tree = new BinaryTreeExample();
        tree.insert(root, 5);
        tree.insert(root, 15);
        tree.insert(root, 8);
        System.out.println(tree.find(root, 8));
        System.out.println(tree.find(root, 80));

        tree.printInOrderRecursion(root);
        System.out.println();
        tree.printPostOrderRecursion(root);
        System.out.println();
        tree.printPreOrderRecursion(root);

        System.out.println();
        System.out.println();
        tree.printInOrderIterative(root);
        System.out.println();
        tree.printPreOrderIterative(root);
        System.out.println();
        tree.printPostOrderIterative(root);
        System.out.println();
        tree.levelOrderTraversal(root);
        System.out.println();
        System.out.println(tree.checkBST(root));
        System.out.println();
        tree.invertTree(root);
        System.out.println();
        tree.printInOrderRecursion(root);
        System.out.println();
        System.out.println(tree.heightOfBinaryTree(root));
        System.out.println(tree.isBalanced(root));
  /*      String s = null;
        System.out.println(s.toString());*/


    }
}
