/*
First Missing Positive 

Given an unsorted integer array, find the first missing positive integer.

Have you met this question in a real interview? Yes
Example
Given [1,2,0] return 3, and [3,4,-1,1] return 2.

Challenge
Your algorithm should run in O(n) time and uses constant space.
*/

public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        
        if(A == null || A.length == 0) {
            return 1;
        }  
        
        int len = A.length;
        int tmp = 0;
        for (int i = 0; i < len;) {
            
            //判定条件很重要
            //可能出现 
            // 负数
            // 特别大的正数超过Len
            // 已经放在正确位置的数
            // 与需要交换的数相同的情况
            
            if (A[i] > 0 && A[i] < len && A[i] != i + 1 && A[i] != A[A[i] - 1]) {
                tmp = A[A[i] -1];
                A[A[i] - 1] = A[i];
                A[i] = tmp;
                continue;
            }
            i++;
        }
        
        // 当出现不连续的正数时，遍历找到
        for( int j = 0 ; j < len; j++) {
            if (A[j] != j + 1) {
                return j + 1;
            }
        }
        
        //当从1开始的正数都是连续的，返回比数组中最大值+1的数
        return len + 1;
    }
}
