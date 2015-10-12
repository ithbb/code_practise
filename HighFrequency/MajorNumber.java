/*
Given an array of integers, the majority number is the number that occurs more than half of the size of the array. Find it.

Have you met this question in a real interview? Yes
Example
Given [1, 1, 1, 1, 2, 2, 2], return 1
*/

public class Solution {
    /**
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        
        if (nums == null || nums.size() == 0 ) {
            return -1;
        }
        
        int count = 0;
        int candidate = -1;
        int vi = -1;
        
        for (int i = 0; i < nums.size(); i++) {
            if (count == 0) {
                
                //自动unbox为Int（java1.5之后）
                candidate = nums.get(i);
                //必须设为1 ！！！
                count = 1;
            } else {
                if (candidate == nums.get(i)) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        return candidate;
    }
}

