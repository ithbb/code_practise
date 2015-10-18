/*
Unique Characters Show result 

42% Accepted
Implement an algorithm to determine if a string has all unique characters.

Have you met this question in a real interview? Yes
Example
Given "abc", return true.

Given "aab", return false.

Challenge
What if you can not use additional data structures?
*/

public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        
        if (str == null || str.length() == 0) {
            return true;
        }
        
        HashMap<Character, Boolean> hashMap = new HashMap<Character, Boolean>();
        
        int length = str.length();
        for(int i = 0; i <length; i++) {
            if(hashMap.containsKey(str.charAt(i))) {
                return false;
            } else {
                hashMap.put(str.charAt(i), true);
            }
        }
        return true;
        
    }
}

