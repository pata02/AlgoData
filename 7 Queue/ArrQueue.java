public class ArrQueue {
    int[] array;
    int i;
    int k;

    public ArrQueue(int size) {
        array = new int[size];
        i = 0;

    }

    private void increaseArr() {
        int[] tempArr = new int[array.length * 2];

        int counter = 0;

        for (int j = i; j < array.length; j++) {
            tempArr[counter] = array[j];
            counter++;
        }
        
        for (int j = 0; j < k; j++) {
            tempArr[counter] = array[j];
            counter++;
        }
        i = 0;
        k = counter;

        array = tempArr;
    }

    public void add(int val) {
        array[k] = val;

        if (k == array.length - 1) {
            k = 0;
        } else {
            k++;
        }

        if (k == i) {
            increaseArr();
        }
    }

    public int remove() {

        int retVal = array[i];
        array[i] = 0;

        if (i == array.length - 1) {
            i = 0;
        } else {
            i++;
        }

        if (i == k) {
            i = 0;
            k = 0;
            System.out.println("Reset queue");
            return 6969;
        }

        return retVal;
    }

    public void printAll() {
        for (int j = 0; j < array.length; j++) {
            if (j == i && j == k) {
                System.out.println(array[j] + "-i and k");

            } else if (j == i && j != k) {
                System.out.println(array[j] + "-i");

            } else if (j != i && j == k) {
                System.out.println(array[j] + "-k");

            } else if (j != i && j != k) {
                System.out.println(array[j]);
            }

        }
    }

    public static void main(String[] args) {
        ArrQueue myQ = new ArrQueue(4);
        myQ.add(1);
        myQ.add(2);
        myQ.add(3);
        myQ.add(4);
    


        myQ.printAll();
    }
}
