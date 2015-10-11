/*
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Have you met this question in a real interview? 

Yes
 




Example 

"A man, a plan, a canal: Panama" is a palindrome.

"race a car" is not a palindrome.

Note 

Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.
*/

public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
    
        if (s == null || s.length() == 0) {
            return true;
        }
        int head = 0;
        int tail = s.length() -1;
        while(head < tail) {
            if(!isValidChar(s.charAt(head))) {
                head++;
                continue;
            }
            if(!isValidChar(s.charAt(tail))) {
                tail--;
                continue;
            }
            if(Character.toUpperCase(s.charAt(head)) != Character.toUpperCase(s.charAt(tail))) {
                return false;
            } else {
                head++;
                tail--;
            }
        }
        return true;
    }
    
    // 可以使用 Character.isLetterOrDigit()
    
    private boolean isValidChar(char c) {
        if (c >= 'a' && c <='z' || c >='A' && c <= 'Z' || c>='0' && c <='9') {
            return true;
        } else {
            return false;
        }
    }
}
