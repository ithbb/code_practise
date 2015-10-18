/*
Hard Longest Increasing Continuous subsequence II

22% Accepted
Give you an integer matrix (with row size n, column size m)，find the longest increasing continuous subsequence in this matrix. (The definition of the longest increasing continuous subsequence here can start at any row or column and go up/down/right/left any direction).

Have you met this question in a real interview? Yes
Example
Given a matrix:

[
  [1 ,2 ,3 ,4 ,5],
  [16,17,24,23,6],
  [15,18,25,22,7],
  [14,19,20,21,8],
  [13,12,11,10,9]
]
return 25

Challenge
O(nm) time and memory.
*/

public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int lenRow = A.length;
        int lenCol = A[0].length;
        
        // f[i][j]从 i，j出发的最长连续序列长度
        int[][] f = new [lenRow + 1][lenCol + 1];
        
        f[0][0] = 0;
        
        for(int i = 0; i < lenRow; i++) {
            f[i][0] = 0;
        }
        
        for(int j = 0; j < lenCol; j++) {
            f[0][j] = 0;
        }
        
        for(int i = 1; i < lenRow + 1; i++) {
            for (int j = 1; j < lenCol + 1; j++) {
                
                int lenE = 1;
                int lenW = 1;
                int lenN = 1;
                int lenS = 1;
                if (Math.abs(A[i][j] - A[i-1][j]) == 1) {
                    lenN = f[i-1][j] + 1;
                }
                if (Math.abs(A[i][j] - A[i+1][j]) == 1) {
                    lenS = f[i+1][j] + 1;
                }
                if (Math.abs(A[i][j] - A[i][j-1]) == 1) {
                    lenW = f[i][j-1] + 1;
                }
                if (Math.abs(A[i][j] - A[i][j+1]) == 1) {
                    lenE = f[i][j+1] + 1;
                }
                f[i][j] = Math.max()
            }
        }
        
    }
    
    private void dfs() {
    }
}

