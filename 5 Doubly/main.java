import java.util.Random;

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

        DoublyList searchList = new DoublyList();
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

    
                DoublyList.Node[] keyList = new DoublyList.Node[n];
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
