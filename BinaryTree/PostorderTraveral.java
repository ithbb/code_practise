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
     * @return: Postorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
         
        TreeNode curNode = root;
        TreeNode preNode = root;
        
        stack.push(root);
        
        while (!stack.empty()) {
            
            curNode = stack.peek();
            
            if(curNode.left == null && curNode.right == null ||
               (preNode != null && (curNode.left == preNode || curNode.right == preNode))) {
              
              list.add(curNode.val); 
              preNode = curNode;
              stack.pop();

            } else {
              
              if(curNode.right != null) {
                  stack.push(curNode.right);

              }
              
              if (curNode.left != null) {
                  stack.push(curNode.left);

              }
            }
        
        }
        return list;
    }
    
}
