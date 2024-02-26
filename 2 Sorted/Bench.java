import java.util.Random;

class Bench {

    private static void linear(int[] array, int[] indx) {
        for (int i = 0; i < indx.length; i++) {
            Linear.search(array, indx[i]);
        }
    }

    private static void linearOpt(int[] array, int[] indx) {
        for (int i = 0; i < indx.length; i++) {
            LinearOpt.search(array, indx[i]);
        }
    }

    private static void binary(int[] array, int[] indx) {
        for (int i = 0; i < indx.length; i++) {
            Binary.search(array, indx[i]);
        }
    }

    private static void oldDup(int[] arr1, int[] arr2) {
        OldDup.search(arr1, arr2);
    }


    private static void duplicate(int[] array, int[] array2) {
        Duplicate.search(array, array2);
    }

    private static void dupOpt(int[] arr1, int[] arr2) {
        DupOpt.search(arr1, arr2);
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

    private static int[] keys(int loop, int n) { // Generates loop-number of numbers in the range of 0 to n*5
        Random rnd = new Random();
        int[] indx = new int[loop];

        for (int i = 0; i < loop; i++) {
            indx[i] = rnd.nextInt(n * 5);
        }
        return indx;
    }

    public static void main(String[] arg) {

        // int[] sizes = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000, 1100,
        // 1200, 1300, 1400, 1500, 1600 };

        int[] sizes = { 8000, 16000, 32000, 64000, 128000 };

        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s%8s%8s%8s\n", "n", "linear", "linOpt", "binary", "oldDup","binDup", "dupOpt");
        for (int n : sizes) {

            int loop = 1000;

            int[] array = sorted(n);
            int[] array2 = sorted(n);
            int[] indx = keys(loop, n);

            System.out.printf("%8d", n);

            int k = 1000;

            // ------------------------------------------------------------
            // Linear
            double min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linear(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min / loop));
            // ------------------------------------------------------------
            // LinearOpt

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                linearOpt(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min / loop));

            // ------------------------------------------------------------
            // Binary

            min = Double.POSITIVE_INFINITY;

            for (int i = 0; i < k; i++) {
                long t0 = System.nanoTime();
                binary(array, indx);
                long t1 = System.nanoTime();
                double t = (t1 - t0);
                if (t < min)
                    min = t;
            }

            System.out.printf("%8.0f", (min / loop));

            // ------------------------------------------------------------
            // Old dup

            min = Double.POSITIVE_INFINITY;
            long sum = 0;

            for (int i = 0; i < 100; i++) {
                array = sorted(n);
                array2 = sorted(n);

                long t0 = System.nanoTime();
                oldDup(array, array2);
                long t1 = System.nanoTime();
                long t = (t1 - t0);
                sum = sum + t;
            }

            System.out.printf("%8d", (sum / 100000));

            // ------------------------------------------------------------
            // binary dup

           min = Double.POSITIVE_INFINITY;
            sum = 0;

            for (int i = 0; i < 100; i++) {
                array = sorted(n);
                array2 = sorted(n);

                long t0 = System.nanoTime();
                duplicate(array, array2);
                long t1 = System.nanoTime();
                long t = (t1 - t0);
                sum = sum + t;
            }

            System.out.printf("%8d", (sum / 100000));

            // ------------------------------------------------------------
            // opt dup

            min = Double.POSITIVE_INFINITY;
            sum = 0;

            for (int i = 0; i < 100; i++) {
                array = sorted(n);
                array2 = sorted(n);

                long t0 = System.nanoTime();
                dupOpt(array, array2);
                long t1 = System.nanoTime();
                long t = (t1 - t0);
                sum = sum + t;
            }

            System.out.printf("%8d\n", (sum / 100000));

            /*
             * min = Double.POSITIVE_INFINITY;
             * 
             * for (int i = 0; i < k; i++) {
             * long t0 = System.nanoTime();
             * binary(array, indx);
             * long t1 = System.nanoTime();
             * double t = (t1 - t0);
             * if (t < min)
             * min = t;
             * }
             * 
             * System.out.printf("%8.0f", (min / loop));
             * 
             * min = Double.POSITIVE_INFINITY;
             * 
             * double[] times = new double[k];
             * 
             * for (int i = 0; i < k; i++) {
             * 
             * array = sorted(n);
             * array2 = sorted(n);
             * 
             * long t0 = System.nanoTime();
             * duplicate(array, array2);
             * long t1 = System.nanoTime();
             * double t = (t1 - t0);
             * 
             * times[i] = t;
             * 
             * if (t < min)
             * min = t;
             * }
             * 
             * System.out.printf("%8.0f", min / 10);
             * 
             * 
             * 
             * int[] arr1 = {1,3,5,7,9,11,13, 14};
             * 
             * int[] arr2 = {0,2,4,6,8,10,15};
             * 
             * if (dupOpt(arr1, arr2)) {
             * System.out.printf("%8.0f\n",1.0);
             * } else {
             * System.out.printf("%8.0f\n",0.0);
             * }
             */

        }
    }
}
