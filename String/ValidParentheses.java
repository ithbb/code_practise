/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

Have you met this question in a real interview? Yes
Example
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        
        if (s == null) {
            return false;
        }
        
        if (s.length() == 0) {
            return true;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0;i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch =='[') {
              stack.push(new Character(ch));    
            } else if (stack.empty() || ch == ')' && !stack.pop().equals('(')
                    || ch == '}' && !stack.pop().equals('{')
                    || ch == ']' && !stack.pop().equals('[')) {
                    return false;
            }
            
        }
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}
