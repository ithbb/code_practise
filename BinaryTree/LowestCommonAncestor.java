/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<Integer, TreeNode> parentMap = new HashMap<>();
        Set<TreeNode> visited= new HashSet<>();
        parentMap.put(root.val, null);
        dfs(root, parentMap);
        
        TreeNode node = p;
        while (node != null) {
            visited.add(node);
            node = parentMap.get(node.val);
        }
        
        node = q;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            } else {
                node = parentMap.get(node.val);
            }
        }
        return null;    
    }
    
    private void dfs(TreeNode node, HashMap<Integer, TreeNode> parentMap) {
        if (node.left != null) {
            parentMap.put(node.left.val, node);
            dfs(node.left, parentMap);
        }
        if (node.right != null) {
            parentMap.put(node.right.val, node);
            dfs(node.right, parentMap);
        }
    }
}
