public class Heap {

    private class Node {
        public Integer val;
        public Node left, right;
        public int size;

        public Node(Integer val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    Node root;

    public Heap() {
        root = null;
    }

    public void add(Integer val) {

        if (root == null) {
            root = new Node(val);
        } else {
            root.size++;
            addRec(val, root);
        }

        return;
    }

    public void addRec(int currVal, Node n) {

        if (n.left == null) {
            n.left = new Node(currVal);
            return;
        }

        if (n.right == null) {
            n.right = new Node(currVal);
            return;
        }

        // If the val is smaller than the left and right node
        if (currVal < n.left.val && currVal < n.right.val) {

            // Change the node and Addrec to the node with the lowest size
            if (n.left.size <= n.right.size) {
                int valHolder = n.left.val;
                n.left.val = currVal;
                addRec(valHolder, n.left);
                n.left.size++;
                return;
            } else {
                int valHolder = n.right.val;
                n.right.val = currVal;
                addRec(valHolder, n.right);
                n.right.size++;
                return;
            }

            // If the val is greater than right and left node
        } else if (currVal > n.left.val && currVal > n.right.val) {

            // Move the val down to the lowest size branch
            if (n.left.size <= n.right.size) {
                addRec(currVal, n.left);
                n.left.size++;
                return;
            } else {
                addRec(currVal, n.right);
                n.right.size++;
                return;
            }
        }

        // If left is larger than the right push it down the left node.
        if (n.left.val >= n.right.val) {
            int valHolder = n.left.val;
            n.left.val = currVal;
            addRec(valHolder, n.left);
            n.left.size++;
            return;
        } else if (n.right.val > n.left.val) {
            int valHolder = n.right.val;
            n.right.val = currVal;
            addRec(valHolder, n.right);
            n.right.size++;
            return;
        }

        System.out.println("Detta borde aldrig komma upp. CurrVal:" + currVal + ". Left:" + n.left.val + ". Right:" + n.right.val);
        

        /*
         * //If currVal is larger than one of them move it down to it
         * if (currVal > currNode.left.val) {
         * addRec(currVal, currNode.left);
         * currNode.size++;
         * return;
         * } else if (currVal > currNode.right.val) {
         * addRec(currVal, currNode.right);
         * currNode.size++;
         * return;
         * } else {
         * System.out.println("Detta borde aldrig komma upp. CurrVal:" + currVal);
         * 
         * }
         * 
         * return;
         */
    }

    public Integer remove() {
        Integer retVal;

        if (root == null) {
            throw new IllegalStateException("Tree is empty, cannot remove");
        }

        retVal = root.val;
        root.val = removeRec(root);

        if (root.val == null) {
            root = null;
        }

        return retVal;
    }

    public Integer removeRec(Node n) {
        Integer retVal;
        n.size--;

        // Om det inte finns några ett flytta upp, returnera null
        if (n.left == null && n.right == null) {
            return null;
        }

        // Om vänster och höger nod finns jämför och
        if (n.left != null && n.right != null) {
            if (n.left.val < n.right.val) {
                retVal = n.left.val;
                n.left.val = removeRec(n.left);

                if (n.left.val == null) {
                    n.left = null;
                }
            } else {
                retVal = n.right.val;
                n.right.val = removeRec(n.right);

                if (n.right.val == null) {
                    n.right = null;
                }
            }

            // Om vänster endast finns, sätt n till vänster, sätt vänster till
            // removeRec(vänster)

        } else if (n.left != null && n.right == null) {
            retVal = n.left.val;
            n.left.val = removeRec(n.left);

            if (n.left.val == null) {
                n.left = null;
            }

            // Samma sak fast om bara höger finns
        } else {
            retVal = n.right.val;
            n.right.val = removeRec(n.right);

            if (n.right.val == null) {
                n.right = null;
            }
        }

        return retVal;
    }

    public int push(Integer incr) {
        Node n = root;
        n.val = n.val + incr;

        return pushRec(n, 0);

    }

    private int pushRec(Node n, int depVal) {
        int valHolder;

        // If left node only exist change only if its lower priority
        if (n.left != null && n.right == null) {
            if (n.val > n.left.val) {
                valHolder = n.val;
                n.val = n.left.val;
                n.left.val = valHolder;
                depVal++;
                return pushRec(n.left, depVal);
            } else {
                return depVal;
            }
        }

        // The same but only right exist
        if (n.left == null && n.right != null) {
            if (n.val > n.right.val) {
                valHolder = n.val;
                n.val = n.right.val;
                n.right.val = valHolder;
                depVal++;
                return pushRec(n.right, depVal);
            } else {
                return depVal;
            }
        }

        //If at a bottom just return the depthval upwards
        if (n.left == null && n.right == null) {
            return depVal;
        }

        // If the val is smaller than the left and right node
        // Dont change anything, return the provided depval
        if (n.val < n.left.val && n.val < n.right.val) {
            return depVal;
        }
   
        

        // Move the val down to the lowest size branch
        if (n.left.val <= n.right.val) {
            valHolder = n.val;
            n.val = n.left.val;
            n.left.val = valHolder;
            depVal++;
            return pushRec(n.left, depVal);
        } else {
            valHolder = n.val;
            n.val = n.right.val;
            n.right.val = valHolder;
            depVal++;
            return pushRec(n.right, depVal);
        }

        
    }

    public void printAll() {
        // Start by calling the private printAll method with the root node and an empty
        // position string
        printAll(root, "");
    }

    private void printAll(Node node, String position) {
        // If the node is null, there's nothing to print, so return
        if (node == null) {
            return;
        }

        // Step 1: Recursively print the left subtree
        printAll(node.left, "Left of " + node.val);

        // Step 2: Print the current node's value along with its position
        System.out.println(position + ": " + node.val + "(" + node.size + ")");

        // Step 3: Recursively print the right subtree
        printAll(node.right, "Right of " + node.val);
    }

}
