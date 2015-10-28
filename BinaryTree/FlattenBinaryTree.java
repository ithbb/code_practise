/*
Flatten Binary Tree to Linked List Show result 

32% Accepted
Flatten a binary tree to a fake "linked list" in pre-order traversal.

Here we use the right pointer in TreeNode as the next pointer in ListNode.

Have you met this question in a real interview? Yes
Example
              1
               \
     1          2
    / \          \
   2   5    =>    3
  / \   \          \
 3   4   6          4
                     \
                      5
                       \
                        6
Note
Don't forget to mark the left child of each node to null. Or you will get Time Limit Exceeded or Memory Limit Exceeded.

Challenge
Do it in-place without any extra memory.
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
    public void flatten(TreeNode root) {
        
        if (root == null || root.left == null && root.right == null) {
            return;
        }
        
        //Pre-Order traveral
        //root , root.left, root.right
        flatten(root.left);
        flatten(root.right);
        
        //递归处理，递归完之后把右子树连接到处理完的左子树最后，再将左子树改成右子树，然后指针赋值空。
        if (root.left != null) {
            TreeNode node = root.left;
            while(node != null && node.right != null) {
                node = node.right;
            }
            node.right = root.right;
            
            root.right = root.left;
            root.left = null;
        }
    }
    
    
}
