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
    public int goodNodes(TreeNode root) {
        int[] ans = new int[1];
        check(root,root.val,ans);
        return ans[0];
    }
    public void check(TreeNode root, int maxvalue, int[] ans){
        if(root==null) return ;
        
        if(root.val >= maxvalue){
            ans[0]++;
            maxvalue=root.val;
        }
        check(root.left,maxvalue,ans);
        check(root.right,maxvalue,ans);
        return ;

    }
}