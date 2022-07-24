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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxi = new int[1];
        
        findMax(root,maxi);
        return maxi[0];
    }
    private int findMax(TreeNode root, int[] maxi)
    {
        if(root==null)
            return 0;
        
        int lh = findMax(root.left,maxi);
        int rh = findMax(root.right,maxi);
        
        maxi[0] = Math.max(maxi[0], lh+rh);
        
        return 1+ Math.max(lh,rh);
    }
}