class Solution {
    public int scoreOfParentheses(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (char c : chars) {
            if (c == '(') {
                stack.push(sum);
                sum = 0;
            } else {
                sum = stack.pop() + Math.max(2*sum, 1);
            }
            
        }
        
        return sum;
    }
}
