/*
Medium Find the Missing Number 

28% Accepted
Given an array contains N numbers of 0 .. N, find which number doesn't exist in the array.

Have you met this question in a real interview? Yes
Example
Given N = 3 and the array [0, 1, 3], return 2.
*/

public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int len = nums.length;
        int target = len *(len+1)/2;
        
        int sum = 0;
        for(int v : nums) {
            sum+= v;
        }
        return target - sum;
    }
}

