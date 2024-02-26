import java.util.Random;

public class main {

    private static int[] unsorted(int n, int range) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        boolean duplicate = false;

        for (int i = 0; i < n; i++) {
            duplicate = false;

            nxt = rnd.nextInt(range);
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

        double totalArrTime = 0;


        for (int q = 0; q < 100; q++) {
            ArrHeap myArrHeap = new ArrHeap(1024);
            
            Random rand = new Random();

            int[] myArr = unsorted(1023, 10000);
            int[] addRand = new int[1023];

            // Adding numbers to heap and creating random numbers
            for (int i = 0; i < 1023; i++) {
                myArrHeap.add(myArr[i]);

                addRand[i] = rand.nextInt(90) + 10;
            }

            // Incrementing by a random value between 10..100
            double t0 = System.nanoTime();

            for (int i = 0; i < 1023; i++) {
                myArrHeap.increment(addRand[i]);
            }

            double t1 = System.nanoTime();

            double tot = (t1 - t0) / 1000;
            totalArrTime += tot;
            System.out.println("Arr incr time: " + tot + " us");
        }

        System.out.println("Totalincr average:" + totalArrTime / 100);

        /*double totalPush = 0;
        double totalRemAdd = 0;

        for (int q = 0; q < 100; q++) {
            Heap myHeap = new Heap();
            Heap myHeap2 = new Heap();
            Random rand = new Random();

            int[] myArr = unsorted(1023, 10000);
            int[] addRand = new int[1023];
            // int[] depRes = new int[1023];

            // Adding numbers to heap adn creating eandom numbers
            for (int i = 0; i < 1023; i++) {
                myHeap.add(myArr[i]);
                myHeap2.add(myArr[i]);

                addRand[i] = rand.nextInt(90) + 10;
            }

            // Incrementing by a random value between 10..100
            // Saving depth to array

            double t0 = System.nanoTime();

            for (int i = 0; i < 1023; i++) {
                myHeap.push(addRand[i]);
            }

            double t1 = System.nanoTime();

            double tot = (t1 - t0) / 1000;
            totalPush += tot;
            // System.out.println("Push time: " + tot + " us");

            // -------------------------------------------------------

            // Incrementing by a random value between 10..100
            // Saving depth to array

            int number;

            t0 = System.nanoTime();
            for (int i = 0; i < 1023; i++) {
                number = myHeap2.remove() + addRand[i];
                myHeap2.add(number);
            }

            t1 = System.nanoTime();

            tot = (t1 - t0) / 1000;
            totalRemAdd += tot;
            // System.out.println("Rem and Add:: " + tot + " us");
        }

        System.out.println("TotalPush:" + totalPush / 100);
        System.out.println("TotalRemAdd:" + totalRemAdd / 100);*/
    }
}
