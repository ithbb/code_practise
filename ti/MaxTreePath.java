class Solution {
    private static int ans = Integer.MIN_VALUE;
    public int PathMax(TreeNode root) {
        if(root == null){
            return 0;
        }
        int left = PathMax(root.left);
        int right = PathMax(root.right);
        int ms = Math.max(Math.max(left,right)+root.val, root.val);
        int ms_1 = Math.max((left+right+root.val), ms);
        ans = Math.max(ans, ms_1);

        return ms;
    }

    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        PathMax(root);
        return ans;
    }
}
