/**
 * Challenge: 
 * Implement insertion sort to arrange an integer array in descending order.
 * 
 * The algorithm must modify the original array in place. During each
 * insertion, it should shift smaller elements to the right and insert
 * the current key into its correct position.
 * 
 * Time complexity:
 * - Best case: O(n)
 * - Average case: O(n^2)
 * - Worst case: O(n^2)
 *
 * Auxiliary space: O(1)
 * 
 * 
 */

public class Week1Day2{
    public static void main(String[] args) {

        int[] A = {31,41,59,26,41,58};

        insertionSort(A);
        
        for(int a: A){
            System.out.println(a);
        }
        
    }

    public static int[] insertionSort(int[] A){

        for(int i = 1; i< A.length; i++){
            int key = A[i];
            int j = i-1;

            while(j >= 0 && A[j] > key){
                A[j+1] = A[j];
                j = j-1;

            }
            A[j+1] = key;
        }

        return A;
    }
}