/*Given a string s and a dictionary of words dict, determine if s can be break into a space-separated sequence of one or more dictionary words.

Have you met this question in a real interview? Yes
Example
Given s = "lintcode", dict = ["lint", "code"].

Return true because "lintcode" can be break as "lint code".

Tags Expand  
*/

public class Solution {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordBreak(String s, Set<String> dict) {
        
        if (s == null || s.length() == 0 ) {
            return true;
        } 
        
        int len = s.length();
        
        boolean[] f = new boolean[len + 1];
        
        if(dict.contains(s.substring(0,1))) {
            f[0] = true;
        } else {
            f[0] = false;
        }
        
        for(int i = 1; i < len; i++) {
            
            if (dict.contains(s.substring(0,i))) {
                    f[i] = true;
                    continue;
                } else {
                    f[i] = false;    
                }
            
            for (int j = 0; j < i; j++) {
                
                if(!dict.contains(s.substring(i-j, i))) {
                    continue;
                }
                
                if (f[j] == true) {
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[len-1];
    }
}
