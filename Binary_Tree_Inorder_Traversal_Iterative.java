
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        
        if (root == null) {
            return list;
        }
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            
            // Find the most left child.
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                //Add the node on the top.
                node = stack.peek();
                list.add(new Integer(node.val));
                
                // Back to the parent
                stack.pop();
                
                // start go to the right child
                node = node.right;
            }
        }
        return list;
    }
}
