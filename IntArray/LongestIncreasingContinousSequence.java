/*
Longest Increasing Continuous subsequence Show result 

26% Accepted
Give you an integer array (index from 0 to n-1, where n is the size of this array)，find the longest increasing continuous subsequence in this array. (The definition of the longest increasing continuous subsequence here can be from right to left or from left to right)

Have you met this question in a real interview? Yes
Example
For [5, 4, 2, 1, 3], the LICS is [5, 4, 2, 1], return 4.

For [5, 1, 2, 3, 4], the LICS is [1, 2, 3, 4], return 4.

Note
O(n) time and O(1) extra space.
*/

public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        
        int length = A.length;

        if (length < 3) {
            return length;
        }
        
        int max = 2;
        int tmp = 2;
        
        for(int i = 1; i < length - 1; i++) {
            if ((A[i] - A[i-1]) * (A[i+1] - A[i]) > 0 ) {
                tmp++;
            } else {
                max = Math.max(max, tmp);
                tmp = 2;
            }
        }
        max = Math.max(max, tmp);
        return max;
    }
}
