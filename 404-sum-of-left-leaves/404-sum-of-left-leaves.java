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
        
        return sumleft(root,false);
        
    }
    private int sumleft(TreeNode root,boolean flag){
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null && flag==true){
            return root.val;
        }
        int left = sumleft(root.left,true);
        int right = sumleft(root.right,false);
        
        
        return left+right ;
    }
}