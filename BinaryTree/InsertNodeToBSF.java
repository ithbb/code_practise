/*
Given a binary search tree and a new tree node, insert the node into the tree. 
You should keep the tree still be a valid binary search tree.
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return node;
        }
        
        if (node == null) {
            return root;
        }
        
        TreeNode curNode = root;
        TreeNode preNode = curNode;
        
        while (curNode!= null) {
            preNode = curNode;
            if (node.val < curNode.val) {
                    curNode = curNode.left;
            } else {
                    curNode = curNode.right;
            }
        }
        
        if (node.val > preNode.val) {
            preNode.right = node;
        } else {
            preNode.left = node;
        }
        
        return root;
    }
}
