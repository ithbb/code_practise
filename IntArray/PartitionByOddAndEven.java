/*
Partition an integers array into odd number first and even number second.

Have you met this question in a real interview? Yes
Example
Given [1, 2, 3, 4], return [1, 3, 2, 4]

*/

public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return;
        }
        
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            
            while(nums[left]%2 == 1 && left < right) {
                left++;
            }
            
            while(nums[right]%2 == 0 && left < right) {
                right--;
            }
            
            if(left < right) {
              int tmp = nums[left];
              nums[left] = nums[right];
              nums[right] = tmp;
            }
        }
    }
}
