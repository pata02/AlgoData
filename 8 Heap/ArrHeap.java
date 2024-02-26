public class ArrHeap {
    int[] arr;
    int size;
    int usedSize;

    public ArrHeap(int n) {
        this.usedSize = 0;
        this.size = n;
        this.arr = new int[n];
    }

    private void swap(int indx1, int indx2) {
        //System.out.println("Swapping " + arr[indx1] + " with " + arr[indx2]);
        int temp = arr[indx1];
        arr[indx1] = arr[indx2];
        arr[indx2] = temp;
    }

    public void add(int val) {
        if (usedSize >= size) {
            System.out.println("ArrayHeap full");
            return;
        }

        arr[usedSize] = val;
        addRec(usedSize);
        usedSize++;
    }

    private void addRec(int n) {
        int nParent;

        // Find parent
        if ((n % 2) == 0) {
            nParent = (n - 2) / 2;
        } else {
            nParent = (n - 1) / 2;
        }

        // Swap is parent is smaller
        if (nParent >= 0 && arr[n] < arr[nParent]) {
            swap(n, nParent);
            addRec(nParent);

        }
    }

    public int remove() {
        int retVal = arr[0];

        arr[0] = arr[usedSize - 1];
        arr[usedSize - 1] = 0;
        sinkRec(0);
        usedSize--;

        return retVal;
    }

    private void sinkRec(int n) {
        // Find children
        int nLeft = (n * 2) + 1;
        int nRight = (n * 2) + 2;

        if (nLeft < arr.length && nRight < arr.length) {
            // If n is bigger than both children, choose smallest
            if (arr[n] > arr[nLeft] && arr[n] > arr[nRight]) {
                if (arr[nLeft] <= arr[nRight]) {
                    swap(n, nLeft);
                    sinkRec(nLeft);
                } else {
                    swap(n, nRight);
                    sinkRec(nRight);
                }
                return;
            }
        }

        if (nLeft < arr.length && arr[nLeft] < arr[nRight]) {
            swap(n, nLeft);
            return;
        }

        if (nRight < arr.length && arr[nRight] < arr[nLeft]) {
            swap(n, nRight);
            return;
        }

    }

    public void increment(int incr) {
        arr[0] = arr[0] + incr;
        sinkRec(0);
    }

    public void printAll() {
        printRec(0, 0);
    }

    private void printRec(int index, int depth) {
        if (index >= usedSize)
            return;

        // Print right child
        printRec(2 * index + 2, depth + 1);

        // Print current node
        for (int i = 0; i < depth; i++) {
            System.out.print("     "); // Add spaces to represent depth
        }
        System.out.println(arr[index]);

        // Print left child
        printRec(2 * index + 1, depth + 1);
    }

    public void printAllOld() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
