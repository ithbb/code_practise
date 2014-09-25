/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Some examples:
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
  
*/

public class Solution {
    public int evalRPN(String[] tokens) {
        //Judge
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        
        Stack<String> stack = new Stack<String>();
        
        int length = tokens.length;
        int ret = 0;
        if (length == 1) {
          stack.push(tokens[0]);
        }
        
        for(int i = 0; i < length; i ++) {
            if(isExpression(tokens[i]) == false) {
                
                  stack.push(tokens[i]);
                 
            } else {
                String p1 = stack.pop();
                String p2 = stack.pop();
                switch(tokens[i]) {
                    case "+":
                      stack.push(String.valueOf(Integer.parseInt(p1) + Integer.parseInt(p2)));
                      break;
                    case "-":
                      stack.push(String.valueOf(Integer.parseInt(p2) - Integer.parseInt(p1)));
                      break;
                    case "*":
                    stack.push(String.valueOf(Integer.parseInt(p2) * Integer.parseInt(p1)));
                      break;
                    case "/":
                      stack.push(String.valueOf(Integer.parseInt(p2) / Integer.parseInt(p1)));
                }
            }
            
        }
        return Integer.parseInt(stack.pop());
    }
        
  
    private boolean isExpression(String s) {
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            return true;
        }
        return false;
    }
    
}
