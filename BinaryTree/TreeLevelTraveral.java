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
     * @return: Level order a list of lists of integer
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.offer(root);
        
        
        while(!queue.isEmpty()) {
            ArrayList<Integer> list1 = new ArrayList<Integer>();
            
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list1.add(node.val);
                
                if (node.left != null) {
                  queue.offer(node.left);
                }
                
                if (node.right != null) {
                  queue.offer(node.right);
                }
            }
            list.add(list1);
        }
        return list;
    }
}
