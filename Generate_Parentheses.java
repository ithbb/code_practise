/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        
        if (n <= 0) {
            return null;
        }

        ArrayList<String> retList = new ArrayList<String>();
        helper(n, n, new String(), retList);
        return retList;
    }
    
    
    private void helper(int l , int r, String item, ArrayList<String> retList) {
        
        if (l == 0 && r == 0) {
            retList.add(item);    
        }

        if (l > 0) {
            helper(l-1, r, item + "(", retList);
        }

        if (r > 0 && l < r) {
            helper(l, r-1, item + ")", retList);
        }

    }
}
