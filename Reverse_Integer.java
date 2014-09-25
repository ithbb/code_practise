/*
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321
*/

public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        int negative = 1;
        if (x < 0) {
            negative = -1;
            x = x * (-1);
        } 
        int reversed = 0;

        
        int time = 0;
         
        while (x > 0) {
         
            reversed = reversed*10 + x%10;
            x = x / 10;
        }

        int ret = reversed*negative;
        return ret;
     }
}
