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
    public LinkedList<Integer> postorderTraversal(TreeNode root) {

        
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
 
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode node = root;           //当前结点 
        TreeNode pre  = null;           //前一次访问的结点 
        
        stack.push(node);
        while(!stack.isEmpty()) {
            
            node = stack.peek();

            if( (node.left == null && node.right == null) ||
                (pre != null && (pre == node.left || pre == node.right)) ) {
                
                list.add(node.val);
                pre = node;
                stack.pop();
            } else {
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            }
        }
        return list;
    
    
    
    
    
    
    
      /*
        while(node !=null || !stack.isEmpty()) {
            //Find the most left child.
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            if (!stack.isEmpty()) {
                node = stack.peek();
                node = node.right;
                if(node == null) {
                    node = stack.peek();
                    list.add(node.val);
                    stack.pop();
                } else {
                   
                }
            }
            
        } // End of while
        */
        
    }
 
}
