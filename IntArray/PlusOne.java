/*
Plus One 
Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.

Have you met this question in a real interview? Yes
Example
Given [1,2,3] which represents 123, return [1,2,4].

Given [9,9,9] which represents 999, return [1,0,0,0].

Tags Expand  

Related Problems Expand 
*/

public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {

        //Version 1
/*        if(digits == null) {
            return null;
        }

        int length = digits.length;

        int newLength = length + 1;

        for (int i = 0; i < length; i++) {
           if (digits[i] < 9) {
               newLength = length;
               break;
           }
        }

        int[] result = new int[newLength];
        int carry = 1;
        for (int j = length - 1; j >= 0; j--) {
            result[j] = digits[j] + carry;
            
            //Bad code:
            //if(result[j] > 9) {
            //    result[j] = 0;
            //    alpha = 1;
            //} else {
            //    alpha = 0;
            //}
            
            //Good code:
            carry = result[j] / 10;
            result[j] = result[j] % 10;
        }
        
        if (carry == 1) {
            result[0] = 1;
        }
        
        return result;
        */
        
        //Version 2
        if (digits == null || digits.length == 0) {
            return digits;
        }
        
        int length = digits.length;
        int carry = 1;
        
        for(int j = length - 1; j > -1; j--) {
            int val = digits[j] + carry;
            digits[j] = val % 10;
            carry = val / 10;
        }
        
        // If carry == 1, means we need another array.
        if (carry == 1) {
            int[] result = new int[length + 1];
            result[0] = 1;
            // If carry == 1, means the following are 0.
            return result;
        } else {
            return digits;
        }
        
    }
}
