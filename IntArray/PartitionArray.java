/*
Partition Array
Given an array nums of integers and an int k, partition the array (i.e move the elements in "nums") such that:

All elements < k are moved to the left
All elements >= k are moved to the right
Return the partitioning index, i.e the first index i nums[i] >= k.

Have you met this question in a real interview? Yes
Example
If nums = [3,2,2,1] and k=2, a valid answer is 1.
*/

public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    if (nums == null || nums.length == 0) {
	        return nums.length;
	    }
	    
	    int left = 0;
	    int right = nums.length - 1;
	    
	    // The "<=" can handle edge case: when all the elements are smaller than k or all are bigger than k.
	    while(left <= right) {
	        
	        while(right >= left && nums[right] >= k) {
	           right--;
	        }
	        
	        while(left <= right && nums[left] < k) {
	            left++;
	        }
	        
	        if (left <= right) {
	            int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
	            right--;
	        }
	    }
	    return left; 
    }
}

