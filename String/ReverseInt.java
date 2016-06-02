/*
 Reverse Integer*/
 
 /*
Reverse digits of an integer. Returns 0 when the reversed integer overflows (signed 32-bit integer).
*/

public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        if (n == 0) return 0;
        
        int minus = 1;
        if (n < 0) {
          minus = -1;
        }
        String s = String.valueOf(Math.abs(n));
        StringBuilder builder = new StringBuilder();
        int size = s.length();
        int i = 1;
        while( i <= size) {
            char tmp = s.charAt(size - i);
            builder.append(tmp);
            i++;
        }
        String rtString = builder.toString();
        
        // Pay Attention to the overflow case!!!
        long rt = Long.parseLong(rtString);
        if (rt > Integer.MAX_VALUE) {
            return 0;
        }
        
        return (int)rt * minus;
        
    }
}
  
