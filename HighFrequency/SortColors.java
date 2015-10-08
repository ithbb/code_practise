/*
Sort Colors Show result 

33% Accepted
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Have you met this question in a real interview? Yes
Example
Given [1, 0, 1, 2], return [0, 1, 1, 2].

Note
You are not suppose to use the library's sort function for this problem.

Challenge
A rather straight forward solution is a two-pass algorithm using counting sort. First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        
        if (nums == null || nums.length == 0) {
            return;
        }
        int length = nums.length;
        int p0 = -1;
        int p2 = length;
        
        for (int i = 0; i < length;) {
            if (nums[i] == 0) {
                  
                if (i > p0) {
                    p0++;
                    int tmp = nums[p0];
                    nums[p0] = nums[i];
                    nums[i] = tmp;
                } else {
                    i++;
                }
                   
                     
                
            } else if (nums[i] == 2) {
                if (i < p2) {
                    p2--;
                    int tmp = nums[p2];
                    nums[p2] = nums[i];
                    nums[i] = tmp;
                                      
                } else {
                    i++;
                }

                
            } else {
                i++;
            }
        }
        return;
    }
}
