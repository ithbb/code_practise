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
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
      
      if (root == null || root == A || root == B) {
          return root;
      }
      
      TreeNode nodeL = lowestCommonAncestor(root.left, A, B);
      TreeNode nodeR = lowestCommonAncestor(root.right, A, B);
      if (nodeL != null && nodeR != null) {
          return root;
          
      } else if (nodeL != null) {
          return nodeL;
          
      } else if (nodeR != null)  {
          return nodeR;
      } else {
          return null;
      }
      
    }
}
