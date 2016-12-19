package edu.virginia.cs.lib.num;

/**
 *
 * @author Jordan Mincey
 */
public class IntHelper {
    /**
     * Compute the gcd of two ints using Euclids algorithm.
     * @param a the first num
     * @param b the second num
     * @return the greatest common divisor of the two nums
     */
    public static int gcd(int a, int b){
        //switch to make a the larger value
        int r;
        if(a < b){
            r = a;
            a = b;
            b = r;
        }
        
        r = a % b;
        while(r != 0){
            a = b;
            b = r;
            r = a % b;
        }
        return b;
    }
    
    /**
     * Find the factorial of the input number
     * @param n a positive number to find the factorial of
     * @return the factorial of the number
     * @throws IllegalArgumentExcpetion for negative inputs
     */
    public static int factorial(int n){
        if(n < 0){
            throw new IllegalArgumentException("Input should be nonnegative.");
        } else if(n < 2){
            return 1;
        } else {
            int accum = 1;
            for(int i=n; i>0; i--)
                accum *= i;
            
            return accum;
        }
    }
}
