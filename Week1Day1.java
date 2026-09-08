/* 
 * Week1Day1: Array Traversal and Basic Analysis
 * 
 * Challenge:
 * Implement two methods that process an integer array:
 * 
 * 1. sum(int[] values)
 *    Returm the sum of all elements in the array
 * 
 *  Requirements:
 *  - Return 0 if the array is null or empty
 *  - Use long to avoid integer overflow when possible 
 * 
 * 2. max(int[] values)
 *    Return the greatest numerical value in the array
 *  
 *  Requirements:
 *  - Throw IllegalArgumentException if the array is null or empty
 *  - The method must work correctly when all values are negative
 *  - Do not initialize the maxium value to zero.
 * 
 * Examples:
 * 
 *  sum(2,5,1,7) -> 15
 *  max(2,5,1,7,) -> 7
 *  sum(-8,-3,-12) -> -23
 *  max(-8,-3,-12) -> -3
 *  sum({}) -> 0
 * 
 * Restrictions:
 * - Use loops and basic Java syntax
 * - Do not use Arrays.stream(), Arrays.sort(), or similar helpet methods
 * - Test the methods with positive, negative, empty, and large values
 * 
 * Learning objectives:
 * - Practice array traversal and loops
 * - Understand int versus long
 * - Handle edge cases
 * - Analyze time and auxiliary space complecity
 * 
 * Expected complexity:
 * - Time: O(n)
 * - Auxiliary space: O(1)
 * 
 */

public class Week1Day1 {

    public static long sum(int[] values) {
        long total = 0;

        if (values != null && values.length > 0) {

            for (int val : values) {
                total += val;
            }
        }

        return total;
    }

    public static int max(int[] values) {
        
        if(values == null || values.length == 0){
            throw new IllegalArgumentException(
                "The array must contain at least one element"
            );
        }
        
        int max = values[0];            
            for (int i = 1; i < values.length; i++) {
                if (values[i] > max) {
                    max = values[i];
                }
            }

        return max;
    }

    public static void main(String[] args) {    

        int[] largeValues = {
                1_500_000_000,
                1_500_000_000
        };

        System.out.println(max(new int[]{-8, -3, -12}));
        System.out.println(max(new int[]{2, 5, 1, 6}));
        System.out.println(sum(new int[]{}));
        System.out.println("LargeSum = " + sum(largeValues));
    }
}

/*
Questions and answers:

1. What happens if the array has one million elements?

Both methods can process an array with one million elements. 
They make only one pass through the array, so their time complexity is O(n), where n is the number of elements.

They use only a few additional variables, so their auxiliary space complexity is O(1). The input array itself still requires memory

2. What happens if all the values are negative?

The sum will remain negative

The max method will return the greatest numerical value. When all values are negative, this is the value closest to zero.

For example, the maxium value of {-8,-3,-12} is -3

3. Why is it not a good idea to initialize max to zero?

Because zero may not be a part of the array.

If all values are negative and max starts at zero, the method could incorrectly return zero instead of the greatest value in the array

For this reason, max should be initialized with the first element.

4. What is the difference between using int total and long total?

An int can store values approximately between -2.1 billion and 2.1 billion

A sum can exceed this range even when the array contains only a few large value. For example:
1,500,000,000 + 1,500,000,000 = 3,000,000,000

This value does not fit in an int, so int could cause an overflow.

A long supports a much larger range, so it is safer for accumulating large sums.

However, long is not unlimited and can also overflow if the result becomes sufficiently large,


*/
