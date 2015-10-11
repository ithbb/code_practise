/*
Easy Invert Binary Tree Show result 

40% Accepted
Invert a binary tree.

Have you met this question in a real interview? Yes
Example
  1         1
 / \       / \
2   3  => 3   2
   /       \
  4         4
Challenge
Do it in recursion is acceptable, can you do it without recursion?
*/

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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        
        if (root == null) {
            return;
        }
        
        // Please be attention: get the value first.
        TreeNode left = root.left;
        TreeNode right = root.right;
        
        // Handle the null case as well !!!!!
        if (right != null) {
            root.left = right;
            invertBinaryTree(root.left);
        } else {
            root.left = null;
        }
        
        if (left != null) {
            root.right = left;
            invertBinaryTree(root.right);
        } else {
            root.right = null;
        }
        
    }
}
