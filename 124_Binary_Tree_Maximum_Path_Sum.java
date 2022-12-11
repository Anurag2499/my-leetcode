class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        solve(root, ans);
        return ans[0];
    }

    public int solve(TreeNode root, int[] ans) {
        if (root == null)
            return 0;

        int lh = Math.max(0, solve(root.left, ans));
        int rh = Math.max(0, solve(root.right, ans));

        // int sum = (lh<0?0:lh) + (rh<0?0:rh) ;
        ans[0] = Math.max(ans[0], root.val + lh + rh);

        return Math.max(lh, rh) + root.val;

    }
}
