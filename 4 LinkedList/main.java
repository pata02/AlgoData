import java.util.Random;

//public class main {
    /*
     * public static void bench() {
     * LinkedList fixedList = new LinkedList(100);
     * 
     * int[] sizes = { 100, 8000, 16000, 32000, 64000, 128000 };
     * 
     * int div = 1000;
     * 
     * System.out.printf("# searching through an array of length n, time in ns\n");
     * System.out.printf("#%7s%8s\n", "n", "v us");
     * 
     * for (int n : sizes) {
     * 
     * long t0 = 0;
     * long t1 = 0;
     * long t = 0;
     * System.out.printf("%8d", n);
     * 
     * double min = Double.POSITIVE_INFINITY;
     * LinkedList varyList = new LinkedList(n);
     * 
     * // ------------------------------------------------------------
     * // add fixed list b to the end of list a
     * 
     * System.out.printf("%8d\n", (t / div));
     * }
     * }
     */
    /* 
    public static void arrayAppend(int[] arr1, int[] arr2) {
        int[] bigArr = new int[arr1.length + arr2.length];

        for (int i = 0; i < arr1.length; i++) {
            bigArr[i] = arr1[i];
        }

        for (int i = 0; i < arr2.length; i++) {
            bigArr[i] = arr2[i];
        }
        return;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);

        for (int i = 0; i < n; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1;
        }
        return array;
    }


    public static void main(String[] args) {

        /*
        LinkedList stack = new LinkedList(1);
        stack.printList();
        System.out.println("Popping 0");
        int holder = stack.pop(stack);
        System.out.println("Returned val:" + holder);
        stack.printList();

        LinkedList fixedList = new LinkedList(100);

        int[] sizes = { 8000, 16000, 32000, 64000, 128000 };

        int k = 10000;
        int div = 1000;

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s\n", "n", "arr");

        for (int n : sizes) {
            int[] arr1 = sorted(n / 8);
            int[] arr2 = sorted(n - (n / 8));

            long t0 = 0;
            long t1 = 0;
            long t = 0;
            System.out.printf("%8d", n);

            LinkedList varyList = new LinkedList(n);

            double min = Double.POSITIVE_INFINITY;
            // ------------------------------------------------------------
            // aallocate linkedlist
            /*for (int i = 0; i < k; i++) {

                t0 = System.nanoTime();
                varyList = new LinkedList(n);

                t1 = System.nanoTime();
                t = (t1 - t0);

                if (t < min) {
                    min = t;
                }
            }
            System.out.printf("%8d", (t / div));


            //Allocate array
            for (int i = 0; i < k; i++) {

                t0 = System.nanoTime();
                arrayAppend(arr1, arr2);

                t1 = System.nanoTime();
                t = (t1 - t0);

                if (t < min) {
                    min = t;
                }
            }
            System.out.printf("%8d\n", (t / div));

        }*/

        /*LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        LinkedList.Node minNod = list.add(3);
        list.printList();
        System.out.println("Inserting 3");
        list.unlink(minNod);
        list.insert(minNod);
        list.printList();

    }*/

    
//}

public class main {

    public static int randomNumber(int n) {
        Random rnd = new Random();
        int retVal = rnd.nextInt(n);
        return retVal;
    }

    private static int[] unsorted(int k) {
        Random rnd = new Random();
        int[] array = new int[k];
        int nxt = 0;

        for (int i = 0; i < k; i++) {
            array[i] = nxt;
            nxt = rnd.nextInt(k);
        }
        return array;
    }


    public static void main(String[] args) {

        LinkedList searchList = new LinkedList();
        int k = 100;
        int loop = 1;
        int div = 1000;
        //int[] randomNumbers = new int[k];
        
        int[] numbers = { 1000, 2000, 4000, 8000};

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s\n", "n", "tid");


        for (int n : numbers) {

            long sum = 0;

            System.out.printf("%8d", n);

            for (int j = 0; j < loop; j++) {

    
                LinkedList.Node[] keyList = new LinkedList.Node[n];
                int[] randomNumbers = unsorted(k);
    
                //Generates a list of nodes 1 to n
                for (int i = 0; i < n; i++) {
                    keyList[i] = searchList.add(i);
                }
    
                //Generates k random numbers
                //for (int i = 0; i < k; i++) {
                //    randomNumbers[i] = unsorted(n, k);
                //}
    
                long t0 = System.nanoTime();
    
                for (int i = 0; i < k; i++) {
                    searchList.unlink(keyList[randomNumbers[i]]);
                    searchList.insert(keyList[randomNumbers[i]]);
                }
    
                long t1 = System.nanoTime();
    
                long t = (t1 - t0);
                
                sum += t;
            }
            System.out.printf("%8d\n", ((sum / loop) / div));
        }

    }

}
