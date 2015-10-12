/*
Easy Sqrt(x) Show result 

23% Accepted
Implement int sqrt(int x).

Compute and return the square root of x.

Have you met this question in a real interview? Yes
Example
sqrt(3) = 1

sqrt(4) = 2

sqrt(5) = 2

sqrt(10) = 3
*/

class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        
        if (x < 0) {
            return -1;
        }
        
        if (x == 0) {
            return 0;
        }
        
        if (x == 1) {
            return 1;
        }
        
        int start = 1;
        double maxSqrt =  Math.sqrt(Integer.MAX_VALUE);
        int end = x/2 < maxSqrt ? x/2 : (int)maxSqrt;
        
        while (start + 1 < end) {
            
            int mid = start + (end - start) / 2;
            
            int sqr = mid * mid;
            
            if (sqr == x) {
                return mid;
            } else if (sqr < x) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (start*start == x) {
            return start;
        }
        
        if (end*end == x) {
            return end;
        }
        // Becareful the x can not be divided perfectly.
        
        return -1;
    }
    
}
