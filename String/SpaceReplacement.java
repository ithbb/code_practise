/*
Space Replacement Show result 

15% Accepted
Write a method to replace all spaces in a string with %20. 
The string is given in a characters array, you can assume it has enough space 
for replacement and you are given the true length of the string.

Have you met this question in a real interview? Yes
Example
Given "Mr John Smith", length = 13.

The string after replacement should be "Mr%20John%20Smith".
*/

public class Solution {
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        if (string == null || string.length == 0) {
            return 0;
        }
        
        int nullstr = 0;
        for(int i = 0; i < length; i++) {
            if(string[i] == ' ') {
                nullstr++;
            }
        }
        
        int rt = length + 2 * nullstr;
        int p = length - 1;
        for(int j = rt - 1; j > -1;) {
            if (string[p] != ' ') {
                string[j] = string[p];
                p--;
                j--;
            } else {
                if (j >= 2) {
                    string[j] = '0';
                    string[j - 1] = '2';
                    string[j - 2] = '%';
                    p--;
                    j=j-3;

                }
            }
        }
        return rt;
    }
}
