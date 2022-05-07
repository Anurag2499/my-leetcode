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
    public boolean isUnivalTree(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        if(root==null)
            return true;
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            TreeNode currentnode = queue.remove();
            if(currentnode.val!=root.val)
                return false;
            
            if(currentnode.left!=null)
                queue.add(currentnode.left);
            if(currentnode.right!=null)
                queue.add(currentnode.right);
            
        }
        return true;
    }
}