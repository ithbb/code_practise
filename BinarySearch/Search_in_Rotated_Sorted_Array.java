/** 
33. Search in Rotated Sorted Array [Medium]

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.


 

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

**/

class Solution {
    public int findMin(int[] nums) {
        int min = nums[0];
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = (start + end) /2;
            if (nums[mid] < min) {
                min = nums[mid];
            }
            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                boolean foundInLeft = false;
                int startValue = nums[start];
                while (start < mid) {
                    if (nums[start] < startValue) {
                        // search left only
                         if (nums[start] < min) {
                             min = nums[start];
                             foundInLeft = true;
                             break;
                         }
                    }
                    start++;
                }
                if (foundInLeft) {
                    break;
                } else {
                    start = mid;
                }
            } else if (nums[start] <= nums[mid]) {
                // left sorted
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < min) {
            min = nums[start];
            
        }
        if (nums[end] < min) {
            min = nums[end];
        }
        return min;
    }
}
