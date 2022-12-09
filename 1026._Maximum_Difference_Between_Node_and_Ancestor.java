class Solution {
    int ans=0;
    public int maxAncestorDiff(TreeNode root) {
        solve(root,root.val,root.val);
        // solve(root.right,root.val,root.val);
        return ans;
    }
    public void solve(TreeNode root, int mini, int maxi)
    {
        if(root==null) return ;

        mini = Math.min(mini, root.val);
        maxi  = Math.max(maxi,root.val);
        ans  = Math.max(ans,(int)Math.abs(maxi-mini));
        solve(root.left,mini,maxi);
        solve(root.right,mini,maxi);
        return ;
    }
}