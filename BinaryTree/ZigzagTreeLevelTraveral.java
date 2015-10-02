/*
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

Have you met this question in a real interview? Yes
Example
Given binary tree {3,9,20,#,#,15,7},

    3
   / \
  9  20
    /  \
   15   7
 

return its zigzag level order traversal as:

[
  [3],
  [20,9],
  [15,7]
]
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
     * @param root: The root of binary tree.
     * @return: A list of lists of integer include 
     *          the zigzag level order traversal of its nodes' values 
     */
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        
        if (root == null) {
            return result;
        }
        
        
        Stack<TreeNode> curStack  = new Stack<TreeNode>();
        Stack<TreeNode> nexStack  = new Stack<TreeNode>();
        
        // For exchange between curStack and nexStack
        Stack<TreeNode> tmpStack;
        
        curStack.push(root);
        
        boolean normalSeq = true;
        
        while(!curStack.empty()) {
           
           ArrayList<Integer> level = new ArrayList<Integer>();
           
            

           while (!curStack.empty()) {
               
               TreeNode curNode = curStack.pop();
               level.add(curNode.val);
               
               if (normalSeq == true) {
                   if (curNode.left != null) {
                       nexStack.push(curNode.left);
                    
                   }
                   if (curNode.right != null) {
                       nexStack.push(curNode.right);
                    
                   }                   
                   
               } else {
                    if (curNode.right != null) {
                       nexStack.push(curNode.right);
                       
                    }
                   
                    if (curNode.left != null) {
                       nexStack.push(curNode.left);
                      
                    }
               }
               
           } // End While
        result.add(level);
        normalSeq = !normalSeq;
        
        // CurStack is empty
        // nexStack is ready
        tmpStack = curStack;
        curStack = nexStack;
        nexStack = tmpStack;
        
        } // End While
        
        return result;
    }
}
