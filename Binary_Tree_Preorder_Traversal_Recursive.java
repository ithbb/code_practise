/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<Integer>();
        
        if (root == null) {
            return list;
        } else {
            list.add(root.val);

            if ( root.left != null) {
              list.addAll(preorderTraversal(root.left));
            }

            if (root.right != null) {
              list.addAll(preorderTraversal(root.right));
            }
            return list;
        }
    }
}
