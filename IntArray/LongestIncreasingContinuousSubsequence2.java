/*
Longest Increasing Continuous subsequence II Show result 

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
*/

public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
     
     
    int[][] f;
    int[][] flag;
     
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
       
        if(A == null || A.length == 0) {
            return 0;
        }
        
        int lenRow = A.length;
        int lenCol = A[0].length;
        
        // f[i][j]从 i，j出发的最长连续序列长度
        f = new int[lenRow][lenCol];
        
        // 已经搜索过没有
        flag = new int[lenRow][lenCol];

        int maxPath = 0;
        //Search the longest path for A[i][j]
        for(int i = 0; i < lenRow; i++) {
            for (int j = 0; j < lenCol; j++) {
                f[i][j] = dfs(i, j, A);
                maxPath = Math.max(maxPath, f[i][j]);
            }
        }
        return maxPath;   
    }

    private int dfs(int x, int y, int[][] A) {
        
        if(flag[x][y] != 0) {
            return f[x][y];
        }

        int lenRow = A.length;
        int lenCol = A[0].length;
        
        int ans = 1;
        int nx = x + 1;
        int ny = y;
        if( 0<= nx && nx < lenRow && 0<= ny && ny < lenCol
            && A[x][y] > A[nx][ny]) {
            ans = Math.max(ans,  dfs(nx, ny, A) + 1);
        }
        
        nx = x - 1;
        if( 0<= nx && nx < lenRow && 0<= ny && ny < lenCol 
            && A[x][y] > A[nx][ny]) {
            ans = Math.max(ans,  dfs( nx, ny, A) + 1);
        }
        
        nx = x;
        ny = y + 1;
        if( 0<= nx && nx < lenRow && 0<= ny && ny < lenCol
            && A[x][y] > A[nx][ny]) {
            ans = Math.max(ans,  dfs( nx, ny, A) + 1);
        }
        
        ny = y - 1;
        if( 0<= nx && nx < lenRow && 0<= ny && ny < lenCol
            && A[x][y] > A[nx][ny]) {
            ans = Math.max(ans,  dfs( nx, ny, A) + 1);
        }
        
        flag[x][y] = 1;
        f[x][y] = ans;
        
        return f[x][y];
    }

/*    int [][]dp;
    int [][]flag ;
    int n ,m;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A.length == 0)
            return 0;
        n = A.length;
         m  = A[0].length;
        int ans= 0;
        dp = new int[n][m];
        flag = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) { 
                dp[i][j] = search(i, j, A);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
    int []dx = {1,-1,0,0};
    int []dy = {0,0,1,-1};
    
    int search(int x, int y, int[][] A)   {
        if(flag[x][y] != 0)    
            return dp[x][y];
        
        int ans = 1; 
        int nx , ny;
        for(int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if(0<= nx && nx < n && 0<= ny && ny < m ) {
                if( A[x][y] > A[nx][ny]) {
                    ans = Math.max(ans,  search( nx, ny, A) + 1);
                }
            }
        }
        flag[x][y] = 1;
        dp[x][y] = ans;
        return ans;
    }*/
}
