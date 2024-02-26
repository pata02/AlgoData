import java.util.Random;


public class arrays {

     private static int[] keys(int loop, int n) {
        Random rnd = new Random();	
        int[] indx = new int[loop];
        for (int i = 0; i < loop ; i++) {
            indx[i] = rnd.nextInt(n*5);
        }	
        return indx;
        }
    
    public static void main(String[] args) {
        /* 
        int[] sizes = { 100,1000, 10000, 100000, 1000000 };
        for (int n : sizes) {
            long total = 0;
            int loop = 10000;
            int[] array = unsorted(n);
            int[] indx = keys(loop, n);
            for (int i = 0; i < loop; i++) {
                long t0 = System.nanoTime();
                search_unsorted(array, indx[i]);
                long t1 = System.nanoTime();
                total += (t1 - t0);

            }
            System.out.println("size" + n + "=" + total / loop + "ns");

        }
        */

        /*
        int[] sizes = { 100,1000, 10000, 100000, 1000000 };

        for (int n : sizes) {
            long total = 0;
            int loop = 10000;
        int [] array = sorted(n);
        int[] indx = keys(loop, n);
        for(int i = 0; i< loop; i++ ){
            long t0 = System.nanoTime();
        search_sorted(array, indx[i]);
            long t1 = System.nanoTime();
            total+=(t1-t0);

        }
        System.out.println("size"+n+"="+total/loop+"ns");

        }
        */

        /*
        int[] sizes = { 100,1000, 10000, 100000, 1000000, 64000000 };

        for (int n : sizes) {
            long total = 0;
            int loop = 10000;
            int[] array = sorted(n);
            int[] indx = keys(loop, n);
            for (int i = 0; i < loop; i++) {
                long t0 = System.nanoTime();
                binary_search(array, indx[i]);
                long t1 = System.nanoTime();
                total += (t1 - t0);

            }
            System.out.println("size" + n + "=" + total / loop + "ns");

        } 
         */

         /* 
        int[] sizes = { 100, 1000, 10000, 100000, };
        long tot = 0;
        for (int n : sizes) {
            int[] enarray = unsorted(n);
            int[] tvåarray = unsorted(n);
            long t0 = System.nanoTime();
            linear(enarray, tvåarray);
            long t1 = System.nanoTime();
            tot += (t1 - t0);
            System.out.println("size" + n + "=" + (t1 - t0) + "ns");
            System.out.println(linear(enarray, tvåarray));
        }
        System.out.println("average= " + (tot / 4) + "ns");
*/
        

          /* 
           int[] sizes = { 100, 1000, 10000, 100000, };
        long tot = 0;
        for (int n : sizes) {
            int[] enarray = sorted(n);
            int[] tvåarray = sorted(n);
            long t0 = System.nanoTime();
            sorteddup(enarray, tvåarray);
            long t1 = System.nanoTime();
            tot += (t1 - t0);
            System.out.println("size" + n + "=" + (t1 - t0) + "ns");
            System.out.println(sorteddup(enarray, tvåarray));
        }
        System.out.println("average= " + (tot / 4) + "ns");
           
           
        */

           
            int[] sizes = { 100,10000, 50000 , 100000, };
        long tot = 0;
        for (int n : sizes) {
            int[] enarray = sorted(n);
            int[] tvåarray = sorted(n);
            long t0 = System.nanoTime();
            finalen(enarray, tvåarray);
            long t1 = System.nanoTime();
            tot += (t1 - t0);
            System.out.println("size" + n + "=" + (t1 - t0) + "ns");
            System.out.println(finalen(enarray, tvåarray));
        }
        System.out.println("average= " + (tot / 4) + "ns");
        
        
            
    }

   



    public static int linear(int[] arr1, int[] arr2){
        int counter = 0;
        for(int i = 0; i <arr1.length; i++){
            if( search_unsorted(arr2, arr1[i]) ){
                counter++;
            }
      
        }
        return counter;
    }

    public static int sorteddup(int[] arr1, int[] arr2) {
        int counter = 0;
        for (int i = 0; i < arr1.length; i++) {

            if (binary_search(arr2, arr1[i])) {
                counter++;
            }
        }
        return counter;
    }

    public static int finalen(int[] arr1, int[] arr2) {
        int count1 = 0;
        int count2 = 0;
        int countdub = 0;
        while (true) {

            if (count1 == arr1.length || count2 == arr2.length) {
                break;
            }

            if (arr1[count1] < arr2[count2]) {
                count1++;
                continue;
            }

            if (arr1[count1] > arr2[count2]) {
                count2++;

                continue;
            }

            if (arr1[count1] == arr2[count2]) {
                countdub++;
                count1++;
                count2++;

                continue;
            }

        }
        return countdub;

    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
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

            nxt = rnd.nextInt(n*5) + 1;
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

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        while (true) {
            int index = first + ((last - first) / 2);
            if (last - first == 1) {
                return false;
            }
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
                first = index;
                continue;
            }
            if (array[index] > key && index > first) {
                last = index;
                continue;
            }
            return false;

        }
    }

    // unsorted sök igenom första elementet i hela andra arrayen och fortsätt
    // sorted array med binary search sök först sen kör binary på andra arrayen

    // final version Keep track of the next element in the first array. If the next
    // element in the second array is smaller than the next in the first, then move
    // forward in the second array. If it is
    // equal (and then we found a duplicate) or greater then we move forward in the
    // first array.
    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
        }
        return false;
    }

    public static boolean search_sorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
            else if(array[index] > key){
                return false;
            }
        }
        return false;
    }


}
