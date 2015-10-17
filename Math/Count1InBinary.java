/*
Count 1 in Binary Show result 

49% Accepted
Count how many 1 in binary representation of a 32-bit integer.

Have you met this question in a real interview? Yes
Example
Given 32, return 1

Given 5, return 2

Given 1023, return 9

Challenge
If the integer is n bits with m 1 bits. Can you do it in O(m) time?
*/

public class Solution {
    /**
     * @param num: an integer
     * @return: an integer, the number of ones in num
     */
    public int countOnes(int num) {
        
        if (num == 0) {
            return 0;
        }
        
        int count = 0;
        while(num != 0) {
            
            int did = num / 2;
            int remain = num % 2;
            num = did;
            if(remain == 1) {
                count++;
            }
        }
        return count;
    }
};
