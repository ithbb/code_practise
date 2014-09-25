/*
Given an input string, reverse the string word by word.

For example,
Given s = "the sky is blue",
return "blue is sky the".

click to show clarification.
*/

public class Solution {
    public String reverseWords(String s) {
        if(s == null) {
            return null;
        }
        if(s.equals("")) {
            return "";
        }
        String[] splitedStrings = s.split(" ");
        Stack<String> stack = new Stack<String>();
        for(String si : splitedStrings) {
            if (!si.equals("")) {
              stack.push(si);
            }
        }
        StringBuffer buffer = new StringBuffer();
        while(stack.isEmpty() == false) {
            buffer.append(stack.pop());
            if(stack.isEmpty() == false) {
                buffer.append(" ");
            }
        }
    
        return buffer.toString();
    }
    
}
