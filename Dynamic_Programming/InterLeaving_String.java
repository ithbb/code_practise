/*
Given three strings: s1, s2, s3, determine whether s3 is formed by the interleaving of s1 and s2.

Have you met this question in a real interview? Yes
Example
For s1 = "aabcc", s2 = "dbbca"

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

*/

public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // Assume length of s3 = length of s1 + length of s2.
        
        if (s3 == null) {
            return false;
        }
        
        
        int len1 = s1.length();
        int len2 = s2.length();
        
        if (len1 + len2 != s3.length()) {
            return false;
        }
        
        boolean[][] f = new boolean[len1+1][len2+1];
        
        f[0][0] = true;
        
        for(int i = 1 ; i < len1 + 1; i++) {
            String s3t = s3.substring(0,i);
            f[i][0] = s1.substring(0,i).equals(s3t);
        }
        

        for(int j = 1 ; j < len2 + 1; j++) {
            String s3t = s3.substring(0,j);
            f[0][j] = s2.substring(0,j).equals(s3t);
        }
        
        
        for(int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                
                int tmp = s3.charAt(i+j-1);
                
                // One possibility
                if (tmp == s2.charAt(j-1)) {
                    f[i][j] = f[i][j-1];
                } 
                
                // OR
                
                if (f[i][j] != true && tmp == s1.charAt(i-1)) {
                    
                    f[i][j] = f[i-1][j];
                }
 
                /*  if (tmp != s1.charAt(i-1) && tmp != s2.charAt(j-1)) {
                    f[i][j] = false;
                }*/
                
            }
                
        }
        
        return f[len1][len2];
    }
}
