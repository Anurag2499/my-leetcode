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
    public int countNodes(TreeNode root) {
        
        if(root==null) return 0;
        int lh = lefth(root);
        int rh = righth(root);
        if(lh==rh) return ((int)Math.pow(2,lh) -1);
        
        return 1+ countNodes(root.left)+countNodes(root.right);
        
            
    }
    private int lefth(TreeNode root){
        if(root==null) return 0;
        return 1+ lefth(root.left);
    }
    private int righth(TreeNode root){
        if(root==null) return 0;
        return 1+ righth(root.right);
    }
   
}