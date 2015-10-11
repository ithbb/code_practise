/*

Count and Say  Show result   



26% 
Accepted

The count-and-say sequence is the sequence of integers beginning as follows:

1, 11, 21, 1211, 111221, ...

1 is read off as "one 1" or 11.

11 is read off as "two 1s" or 21.

21 is read off as "one 2, then one 1" or 1211.

Given an integer n, generate the nth sequence.
*/

public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        
        if (n == 0) {
            return null;
        }
        
        String[] s = new String[n+1];
        s[0] = "";
        s[1] = "1";

        for(int i = 2; i < n + 1; i++) {
            StringBuilder sb = new StringBuilder();
            int len = s[i-1].length();
            int count = 1;
            for(int j = 0; j < len; j++) {
                
                if (j+1 < len && s[i-1].charAt(j) == s[i-1].charAt(j+1)) { 
                    count++;
                } else {
                    sb.append(String.valueOf(count)).append(s[i-1].charAt(j));
                    //sb.append(count + "" + s[i-1].charAt(j));
                    
                    //Reset count
                    count = 1;
                }
                
                
            }
            s[i] = sb.toString();
        }
        
        return s[n];
        
    }
}
