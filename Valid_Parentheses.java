/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
*/

public class Solution {
    public boolean isValid(String s) {
        //exception
        if (s == null) {
            return false;
        }
        
        if (s.length() == 0) {
            return true;
        }
        
        //build stack
        Stack<String> stack = new Stack<String>();
        int length = s.length();
        for(int i = 0 ; i < length; i ++) {
            String c = s.substring(0,1);
            s = s.substring(1);
            switch(c) {
                case "(":
                case "[":
                case "{":
                  stack.push(c);
                  break;
                case ")":
                  if (stack.isEmpty()) {
                      return false;
                  }
                  String latest1 = stack.pop();
                  if (!latest1.equals("(")) {
                      return false;
                  }
                  break;
                case "]":
                  if (stack.isEmpty()) {
                      return false;
                  }
                  String latest2 = stack.pop();
                  if (!latest2.equals("[")) {
                      return false;
                  }
                  break;
                case "}":
                  if (stack.isEmpty()) {
                      return false;
                  }
                  String latest3 = stack.pop();
                  if (!latest3.equals("{")) {
                      return false;
                  }
                  break;
            }
        }
        
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
