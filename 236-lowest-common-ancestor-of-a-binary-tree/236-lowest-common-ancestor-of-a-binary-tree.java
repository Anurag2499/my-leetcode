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
        if(root==null)
            return root;
        if(root==p || root==q)
            return root;
        
        TreeNode lef = lowestCommonAncestor(root.left,p,q);
        TreeNode righ = lowestCommonAncestor(root.right,p,q);
        // if(lef!=null && righ!=null) return root;
        if(lef==null)
            return righ;
        else if(righ==null)
            return lef;
        else 
            return root;
            
        
    }
        
}