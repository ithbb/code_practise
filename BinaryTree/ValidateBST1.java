/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    
    
  /**
     *  Result type for validation result
    */
    private class ResultType {
        boolean isBst;
        int maxValue; // 最大值
        int minValue; // 最小值
        public ResultType (boolean bst, int max, int min) {
            isBst = bst;
            maxValue = max;
            minValue = min;
        }
    }    
    
    
    
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return gather(root).isBst;
    }
    
    
    
    private ResultType gather(TreeNode node) {
        
        
        if (node == null) {
            return new ResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        if (node.left == null && node.right == null) {
            return new ResultType(true, node.val, node.val);
        }
        
        
        
        ResultType rtL = gather(node.left);
        
        
        ResultType rtR = gather(node.right);
        
        
        if (!rtL.isBst || !rtR.isBst) {
            return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } 
        
        
        
        
        if (node.val > rtL.maxValue && node.val < rtR.minValue) {
            return new ResultType(true, Math.max(node.val, rtR.maxValue), Math.min(node.val, rtL.minValue));
        } else {
            return new ResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        
        

    }
    
  
}
