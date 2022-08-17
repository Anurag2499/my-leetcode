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
    
    private TreeNode helper(TreeNode root)
    {
        if(root.left==null)
            return root.right;
        if(root.right==null)
            return root.left;
        TreeNode depth = leftdepth(root.left);
        depth.right = root.right;
        return root.left;
    }
    
    private TreeNode leftdepth(TreeNode root)
    {
        while(root.right!=null)
        {
            root=root.right;
        }
        return root;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(root.val ==key)
            return helper(root);

        
        TreeNode curr = root;
        
        while(root!=null)
        {
            if(root.left!=null && root.left.val== key)
            {
                root.left = helper(root.left);
                break;
            }
            if(root.right!=null && root.right.val== key)
            {
                root.right = helper(root.right);
                break;
            }
            
            if(root.val > key)
            {
                root=root.left;
            }
            else
                root=root.right;
            
        }
        return curr;
    }
    
}