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
    public int sumOfLeftLeaves(TreeNode root) {
        int[] ans = new int[1];
        sumleft(root,ans,false);
        return ans[0];
    }
    private void sumleft(TreeNode root, int[] ans,boolean flag){
        if(root==null)
            return;
        
        if(root.left!=null)
        {
            sumleft(root.left,ans,true);
        }
        if(root.right!=null)
            sumleft(root.right,ans,false);
        
        if(root.left==null && root.right==null && flag==true){
            ans[0]+=root.val;
        }
        
        return ;
    }
}