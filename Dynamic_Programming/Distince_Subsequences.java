/*
Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string
by deleting some (can be none) of the characters without disturbing the relative positions 
of the remaining characters. 
(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

*/

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        
        if (S == null || T == null) {
            return 0;
        }
        
        if (S.length() < T.length()) {
            return 0;
        }
        
        int lenA = S.length();
        int lenB = T.length();
        
        int[][] f = new int[lenA+1][lenB+1];
        
        for (int l = 0; l < lenA + 1; l++) {
            f[l][0] = 1;
        }
        
        for (int r = 1; r < lenB + 1; r++) {
            f[0][r] = 0;
        }
        
        for(int i = 1; i < lenA + 1; i++) {
            for (int j = 1; j <lenB + 1; j++) {
                if (S.charAt(i-1) != T.charAt(j-1)) {
                    f[i][j] = f[i-1][j];
                } else {
                    f[i][j] = f[i-1][j-1] + f[i-1][j];    
                }    
            }
        }
        
        return f[lenA][lenB];
   
    }
}
