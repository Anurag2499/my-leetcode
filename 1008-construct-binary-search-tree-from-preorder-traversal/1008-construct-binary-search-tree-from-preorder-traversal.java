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
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length==1) return new TreeNode(preorder[0]);
        
        int start=0;
        int end = preorder.length-1;
        
        return bst(preorder,start,end);
    }
    private TreeNode bst(int[] pre ,int start, int end )
    {
        if(start>end) return null;
        
        TreeNode root = new TreeNode(pre[start]);
        
        int lstart = start+1;
        int lend = start;
        int rstart = start;
        int rend = end;
        for(int i=start+1;i<=end;i++)
        {
            if(pre[i]<pre[start])
                lend=i;
            else break;
        }
        rstart = lend+1;
        
        root.left = bst(pre,lstart,lend);
        root.right = bst(pre, rstart,rend);
        return root;
    }
}