
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<Integer> list = new LinkedList<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.peek();
                list.add(new Integer(node.val));
                stack.pop();
                node = node.right;
            }
        }
        return list;
    }
}
