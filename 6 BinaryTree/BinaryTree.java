import java.util.Iterator;
import java.util.Random;

public class BinaryTree implements Iterable<Integer> {
    private static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[1000];
        int nxt = 0;
        boolean duplicate = false;

        for (int i = 0; i < 1000; i++) {
            duplicate = false;

            nxt = rnd.nextInt(n * 5) + 1;
            for (int j = 0; j < i; j++) {
                if (nxt == array[j]) {
                    i--;
                    duplicate = true;

                }

            }

            if (duplicate == false) {

                array[i] = nxt;
            }
        }
        return array;
    }


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

    public Integer lookup(Integer key) {
        Node node = root;

        

        while (node != null) {
            if (key.equals(node.key)) {
                return node.value;
            }

            if (key < node.key) {
                node = node.left;
            } else if (key > node.key) {
                node = node.right;
            }
        }

        return null;
    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    public class TreeIterator implements Iterator<Integer> {
        private Node next;
        private DoublyList stack;

        public TreeIterator() {
            // System.out.println("-TreeIterator");
            next = root;
            stack = new DoublyList();

            while (next != null) {
                stack.push(next);
                // System.out.println("Pushed: " + next.value);
                next = next.left;
            }
        }

        @Override
        public boolean hasNext() {
            if (stack.length() == 0) {
                // System.out.println("-hasNext: False");
                return false;
            } else {
                // System.out.println("-hasNext: True");
                return true;
            }
        }

        @Override
        public Integer next() {
            Node current = stack.pop(stack);
            next = current;

            if (next.right != null) {
                next = next.right;
                stack.push(next);

                while (next.left != null) {
                    next = next.left;
                    stack.push(next);
                }
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
        int[] numbers = { 2000, 8000, 16000, 32000, 64000};
        long loop = 1000;
        int k = 1000;
        int div = 1000;

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s\n", "n", "BinSear");

        for (int n : numbers) {

            if (n != 2000) {
                System.out.printf("%8d", n); 
            }    
        
            long sum = 0;

            double min = Double.POSITIVE_INFINITY;

            for (int j = 0; j < loop; j++) {

                int[] keys = unsorted(n);

                for (int i = 0; i < 1000; i++) {
                    tree.add(keys[i], 5);
                    //System.out.println("key" + i + ": " + keys[i]);
                }

                sum = 0;
                
                for (int i = 0; i < k; i++) {

                    long t0 = System.nanoTime();
                    Integer temp = tree.lookup(keys[i]);
                    long t1 = System.nanoTime();

                    long t = (t1 - t0);

                    sum += t;
                }

                if (sum < min)
                    min = sum;
            }

            if (n != 2000) {
                System.out.printf("%8d\n", (sum / k)); 
            }

        }

        //for (int i : tree)
        //   System.out.println("next value " + i);

        // System.out.println("Iterating through");
        // for (Integer val : tree) {
        // System.out.println(val);
        // }

        // tree.print(tree.root);
        // System.out.println(tree.lookup(12));
        // System.out.println("Binary Tree:");
        // tree.printAll(tree.root);
        // Integer value1 = tree.lookup(12);
        // System.out.println(" " + value1);

    }
}