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
    int i=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int bound = Integer.MAX_VALUE;
        return bst(preorder, bound);
    }
    private TreeNode bst(int[] pre, int bound)
    {
        if(i>=pre.length || pre[i]>bound) return null;
        
        TreeNode root = new TreeNode(pre[i++]);
        root.left = bst(pre , root.val);
        root.right = bst(pre , bound);
        return root;
    }
}