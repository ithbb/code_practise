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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
// Version1
        if (root == null) {
            return true;
        }
        if (Math.abs(maxDepth(root.left) - maxDepth(root.right)) <=1 ) {
            return isBalanced(root.left) && isBalanced(root.right);
        } else {
            return false;
        }




// Version2        
/*        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        
        if (root.left != null && root.right == null) {
            if (root.left.left != null || root.left.right != null) {
                return false;
            }
        }
        
        if (root.right != null && root.left == null) {
            if (root.right.left != null || root.right.right != null) {
                return false;
            }
        }
        
        //root.left != null and root.righ != null
        return isBalanced(root.left) && isBalanced(root.right); */ 
        
    }
    
    private int maxDepth(TreeNode node) {
        
        if (node == null) {
            return 0;
        }
        
        if (node.left == null && node.right == null) {
            return 1;
        }
        
        return Math.max(maxDepth(node.left), maxDepth(node.right)) + 1;
    }
}
