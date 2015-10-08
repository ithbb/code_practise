/*
Given an array of integers, find a contiguous subarray which has the largest sum.

Have you met this question in a real interview? Yes
Example
Given the array [−2,2,−3,4,−1,2,1,−5,3], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(ArrayList<Integer> nums) {
        
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int N = nums.size();
        
        // 以i为结尾的最大值为F[i]
        int[] f = new int[N];
        
        f[0] = nums.get(0).intValue();
        int max = f[0];
        
        for (int i = 1; i < N; i++) {
            f[i] = Math.max(f[i-1] + nums.get(i).intValue(), nums.get(i).intValue());
            if (max < f[i]) {
                max = f[i];
            }
        }
        
        return max;
 
    }
}
