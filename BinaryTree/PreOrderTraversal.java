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
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (root == null) {
            return list;
        }
 
        // Version1       
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        stack.push(root);
        
        while (!stack.empty()) {
            
            TreeNode curNode = stack.pop();
            list.add(curNode.val);
            
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
        
        return list;
        
        //Version2
/*        list.add(root.val);
        if (root.left != null) {
          list.addAll(preorderTraversal(root.left));
        }
        
        if (root.right != null) {
          list.addAll(preorderTraversal(root.right));
        }
        
        return list;*/
        
    }
 }


        //Version3
/*        
public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (root == null) {
            return list;
        }
        
        traversal(root, list);
        
        return list;
    }
    
    private void traversal(TreeNode node, ArrayList<Integer> result) {
        
        result.add(node.val);
        
        if (node.left != null) {
            traversal(node.left, result);
        }
        
        if (node.right != null) {
            traversal(node.right, result);
        }
        
        
    }
}*/
