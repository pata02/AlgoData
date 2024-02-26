import java.util.Iterator;
import java.util.Random;

public class BinaryTree implements Iterable<Integer> {
    /*
     * private static int[] unsorted(int n) {
     * Random rnd = new Random();
     * int[] array = new int[1000];
     * int nxt = 0;
     * boolean duplicate = false;
     * 
     * for (int i = 0; i < 1000; i++) {
     * duplicate = false;
     * 
     * nxt = rnd.nextInt(n * 5) + 1;
     * for (int j = 0; j < i; j++) {
     * if (nxt == array[j]) {
     * i--;
     * duplicate = true;
     * 
     * }
     * 
     * }
     * 
     * if (duplicate == false) {
     * 
     * array[i] = nxt;
     * }
     * }
     * return array;
     * }
     */

    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(Integer key, Integer value) {
        root = addFunc(root, key, value);
    }

    private Node addFunc(Node node, Integer key, Integer value) {
        if (node == null) {
            node = new Node(key, value);
            return node;
        }

        if (key < node.key) {
            node.left = addFunc(node.left, key, value);

        } else if (key > node.key) {
            node.right = addFunc(node.right, key, value);

        } else {
            node.value = value;
        }

        return node;
    }

    /*
     * public Integer lookup(Integer key) {
     * Node node = root;
     * 
     * 
     * 
     * while (node != null) {
     * if (key.equals(node.key)) {
     * return node.value;
     * }
     * 
     * if (key < node.key) {
     * node = node.left;
     * } else if (key > node.key) {
     * node = node.right;
     * }
     * }
     * 
     * return null;
     * }
     */

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<Integer> {
        private Node next;
        private Queue queue;

        public TreeIterator() {
            // System.out.println("-TreeIterator");
            next = root;
            queue = new Queue();

            if (next != null) {
                queue.add(next);
                System.out.println("Pushed: " + next.value);
            }
  
        }

        @Override
        public boolean hasNext() {
            if (queue.length() == 0) {
                // System.out.println("-hasNext: False");
                return false;
            } else {
                // System.out.println("-hasNext: True");
                return true;
            }
        }

        @Override
        public Integer next() {
            if (hasNext() == false) {
                throw new UnsupportedOperationException("The queue is empty");
            }

            Node current = queue.remove();

            if (current.left != null) {
                queue.add(current.left);
            }
            
            if (current.right != null) {
                queue.add(current.right);
            }

            return current.value;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /*
     * public void printAll(Node node) {
     * if (node != null) {
     * printAll(node.left);
     * System.out.println("Key: " + node.key + ", Value: " + node.value);
     * printAll(node.right);
     * }
     * }
     */

    public void print(Node node) {

        if (node.left != null) {
            print(node.left);
        }

        System.out.println("key: " + node.key + "\t\tvalue: " + node.value);

        if (node.right != null) {
            print(node.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.add(4, 40);
        tree.add(3, 30);
        tree.add(5, 50);
        tree.add(2,20);
        tree.add(6, 60);
        tree.add(1, 10);
        
        for (int i :  tree)
        System.out.println("Val:" + i);
    }
}
