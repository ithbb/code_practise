/* A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.
*/

public class Solution {
    public int numDecodings(String s) {
        
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int[] counts = new int[s.length()];
        
        int length = s.length();
        
        for(int i = length - 1; i >= 0; i--) {
            
            int count = 0;
            // one word
            String s1 = s.substring(i, i+1);
            int int1 = Integer.parseInt(s1);
            if (int1 >0 && int1 <=9) {
                if (i < length  - 1) {
                  count = count + counts[i + 1];
                } else {
                  count = 1;
                }
            }
            // two words
            if (i <= length - 2) {
                 String s2 = s.substring(i, i+2);
                int int2 = Integer.parseInt(s2);
                if (int2 >= 10 && int2 <=26) {
                      
                     if (i < length - 2) {
                        count = count + counts[i + 2];
                    } else {
                        count = count + 1;
                    } 
                } 
               
            }
            counts[i] = count;
        }
        return counts[0];
  }
}
