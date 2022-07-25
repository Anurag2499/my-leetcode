/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root==null)
            return  -1001;
        int ans=0;
        int lmax = maxsum(root.left);
        int rmax = maxsum(root.right);
        ans = Math.max((root.val + lmax+ rmax),Math.max((root.val+lmax),Math.max((root.val+rmax),root.val)));
        
        return  Math.max(ans, Math.max(maxPathSum(root.left),maxPathSum(root.right)));
    }
    private int maxsum(TreeNode root)
    {
        if(root==null)
            return 0;
        int ans= Math.max(maxsum(root.left),maxsum(root.right));
        if(ans<0)
            ans=0;
        return root.val+ans ;
    }
}