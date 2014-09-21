/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.

Follow up:
Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

/*  算法
常数空间的话，第一可以考虑是不是固定数量的几个变量能搞定；否则可以考虑是不是问题本身已经提供了足够的空间。
这道题属于后者，就是利用矩阵的第一行和第一列来作为辅助空间使用。不用开辟新的存储空间。方法就是：
1.先确定第一行和第一列是否需要清零
即，看看第一行中是否有0，记下来。也同时记下来第一列中有没有0。

2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
这里不用担心会将本来第一行或第一列的1改成了0，因为这些值最后注定要成为0的。

3.根据第一行和第一列的信息，已经可以将剩下的矩阵元素赋值为结果所需的值了
即，拿第一行为例，如果扫描到一个0，就将这一列都清0.

4.根据1中确定的状态，处理第一行和第一列。
如果最开始得到的第一行中有0的话，就整行清零。同理对列进行处理。
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        boolean firstRowZero = false;
        boolean firstColZero = false;
        
        // first row and column
        for (int i = 0 ; i < m ; i ++) {
            if (matrix[i][0] == 0) {
                firstRowZero = true;
            }
        }
        for (int j = 0; j < n ; j++) {
            if (matrix[0][j] == 0) {
                firstColZero = true;
            }
        }
        
        //search for all remaining data
        for (int i = 1; i < m; i++) {
            for(int j= 1; j< n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        
        
        //handle and update to zero
        // first row and column
        for (int i = 1 ; i < m; i ++) {
            if (matrix[i][0] == 0) {

                for(int j = 1; j < n ; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        for (int j = 1; j < n ; j++) {
            if (matrix[0][j] == 0) {
                
                for(int i = 1; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        
        if (firstColZero == true) {

            for(int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        
        if (firstRowZero == true) {
            for(int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        
    }
}
