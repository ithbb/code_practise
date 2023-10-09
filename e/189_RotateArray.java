/**
*Input: nums = [1,2,3,4,5,6,7], k = 3
*Output: [5,6,7,1,2,3,4]
*Explanation:
*rotate 1 steps to the right: [7,1,2,3,4,5,6]
*rotate 2 steps to the right: [6,7,1,2,3,4,5]
*rotate 3 steps to the right: [5,6,7,1,2,3,4]
**/

class Solution {
    public void rotate(int[] nums, int k) {
        if (k <= 0) {
            return;
        }
        int size = nums.length;
        k %= nums.length;
      // Rotate for all first -> easy to handle from the beginning.
        reverse(nums, 0, size - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, size - 1);
        
    }

    private void reverse(int[] nums, int start, int end) {
       int exchange;
       while (start < end) {          
          exchange = nums[start];
          nums[start] = nums[end];
          nums[end] = exchange;
          start++;
          end--;
        }
    }
}
