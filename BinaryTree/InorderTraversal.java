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
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        // Comparing to PreOrder, need another current node to push and pop the children nodes.
        TreeNode curNode = root;
        
        while (!stack.empty() || curNode != null) {
            
            
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            
            
            
            curNode = stack.pop();
            list.add(curNode.val);
            
           
            curNode = curNode.right;
            

        }
        
        return list;
        
        //Version2
/*        if (root.left != null) {
            list.addAll(inorderTraversal(root.left));
        }
        
        list.add(root.val);
        
        if (root.right != null) {
            list.addAll(inorderTraversal(root.right));
        }
        
        return list;*/
    }
}
