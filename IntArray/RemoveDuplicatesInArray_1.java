/*
Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

Have you met this question in a real interview? Yes
Example
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2].
*/
public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int length = nums.length;
        
        if (length <=1) {
            return length;
        }
        
        int newIndex = 0;
        //使用两根指针(下标)，一个指针(下标)遍历数组，另一个指针(下标)只取不重复的数置于原数组中。
        for(int i = 1; i < length; i++) {
            if (nums[newIndex] != nums[i]) {
                nums[newIndex+1] = nums[i];
                newIndex++;
            }
        }
        return newIndex + 1;
    }
}

