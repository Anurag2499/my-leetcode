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
    public TreeNode pruneTree(TreeNode root) {
        
        if(root==null) return null;
        if(!containsOne(root)) return null;
        if(containsOne(root.left)) pruneTree(root.left);
        else root.left=null;
        
        if(containsOne(root.right)) pruneTree(root.right);
        else root.right=null;
        
        return root;
    }
    boolean containsOne(TreeNode root){
        if(root==null) return false;
        
        if(root.val==1) return true;
        
        return containsOne(root.left)||containsOne(root.right);
        
    }
}