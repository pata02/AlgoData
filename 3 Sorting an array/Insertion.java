public class Insertion {
    public static void insertionsort(int [] array){
        for (int i = 0; i < array.length; i++) {
    
            for (int j = i; j > 0 && array[j] > array[j-1] ; j--) {
    
            swap(array, j, j-1);
    
            }
            }
    
    
        }
    
        public static void swap(int array[], int ett, int två) {
            int håll = 0;
            håll = array[ett];
            array[ett] = array[två];
            array[två] = håll;
    
        }
    
}
