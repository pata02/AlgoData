import java.util.Arrays;
import java.util.Random;
/*
public class main {

    private static void selection(int[] arr) {
        Selection.sort(arr);
    }

    private static void insert(int[] arr) {
        Insert.sort(arr);
    }

    private static void merge(int[] arr) {
        Merge.sort(arr);
    }

    private static void mergeOpt(int[] arr) {
        MergeOpt.sort(arr);
    }

    private static int[] unsorted1(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;

        for (int i = 0; i < n; i++) {
            array[i] = nxt;
            nxt = rnd.nextInt(n);
        }
        return array;
    }

    private static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
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

    public static void main(String[] args) {

        int[] sizes = { 8000, 16000, 32000, 64000, 128000 };
        int div = 1000;
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s%8s%8s%8s\n", "n", "select", "insert", "merge", "mrgOpt", " ", " ");
        for (int n : sizes) {
            int loop = 10;
            int k = 10;
            int[] myArr = unsorted(n);

            long sum = 0;
            System.out.printf("%8d", n);

            // ------------------------------------------------------------
            // Selection
            for (int q = 0; q < loop; q++) {

                double min = Double.POSITIVE_INFINITY;
                sum = 0;

                for (int i = 0; i < k; i++) {
                    long t0 = System.nanoTime();
                    selection(myArr);
                    long t1 = System.nanoTime();
                    long t = (t1 - t0);
                    if (t < min) {
                        min = t;
                    }
                }

                sum += min;
            }

            System.out.printf("%8d", (sum / loop) / div);

            // ------------------------------------------------------------
            // Insertion
            for (int q = 0; q < loop; q++) {

                double min = Double.POSITIVE_INFINITY;
                sum = 0;

                for (int i = 0; i < k; i++) {
                    long t0 = System.nanoTime();
                    insert(myArr);
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    if (t < min) {
                        min = t;
                    }
                }

                sum += min;
            }

            System.out.printf("%8d", (sum / loop) / div);

            // ------------------------------------------------------------
            // merge
            for (int q = 0; q < loop; q++) {

                double min = Double.POSITIVE_INFINITY;
                sum = 0;

                for (int i = 0; i < k; i++) {
                    long t0 = System.nanoTime();
                    merge(myArr);
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    if (t < min) {
                        min = t;
                    }
                }

                sum += min;
            }

            System.out.printf("%8d", (sum / loop) / div);

            // ------------------------------------------------------------
            // Insertion
            for (int q = 0; q < loop; q++) {

                double min = Double.POSITIVE_INFINITY;
                sum = 0;

                for (int i = 0; i < k; i++) {
                    long t0 = System.nanoTime();
                    mergeOpt(myArr);
                    long t1 = System.nanoTime();
                    double t = (t1 - t0);
                    if (t < min) {
                        min = t;
                    }
                }

                sum += min;
            }

            System.out.printf("%8d\n", (sum / loop) / div);

        }
    }
}
*/

public class main {

    private static void selection(int[] arr) {
        Selection.sort(arr);
    }

    private static void insert(int[] arr) {
        Insert.sort(arr);
    }

    private static void insertion(int[] arr) {
        Insertion.insertionsort(arr);
    }

    private static void merge(int[] arr) {
        Merge.sort(arr);
    }

    private static void mergeOpt(int[] arr) {
        MergeOpt.sort(arr);
    }

    private static int[] unsorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
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

    private static int[] unsorted1(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;

        for (int i = 0; i < n; i++) {
            array[i] = nxt;
            nxt = rnd.nextInt(n);
        }
        return array;
    }

    public static void main(String[] args) {

        int[] sizes = { 8000, 16000, 32000, 64000, 128000 };
        int div = 1000;
        System.out.printf("# searching through an array of length n, time in ns\n");
        System.out.printf("#%7s%8s%8s%8s%8s%8s%8s\n", "n", "select", "insert", "merge", "mrgOpt", " ", " ");
        for (int n : sizes) {
            int[] myArr = unsorted1(n);

            long t0 = 0;
            long t1 = 0;
            long t = 0;
            long sum = 0;
            System.out.printf("%8d", n);

            // ------------------------------------------------------------
            // Selection

            double min = Double.POSITIVE_INFINITY;
            sum = 0;

            t0 = System.nanoTime();
            selection(myArr);
            t1 = System.nanoTime();
            t = (t1 - t0);

            System.out.printf("%8d", (t / div));

            // ------------------------------------------------------------
            // insert

            min = Double.POSITIVE_INFINITY;
            sum = 0;

            t0 = System.nanoTime();
            insert(myArr);
            t1 = System.nanoTime();
            t = (t1 - t0);

            System.out.printf("%8d", (t / div));

            // ------------------------------------------------------------
            // merge

            min = Double.POSITIVE_INFINITY;
            sum = 0;

            t0 = System.nanoTime();
            merge(myArr);
            t1 = System.nanoTime();
            t = (t1 - t0);

            System.out.printf("%8d", (t / div));

            // ------------------------------------------------------------
            // mergeopt

            min = Double.POSITIVE_INFINITY;
            sum = 0;

            t0 = System.nanoTime();
            mergeOpt(myArr);
            t1 = System.nanoTime();
            t = (t1 - t0);

            System.out.printf("%8d\n", (t / div));
        }
    }
}