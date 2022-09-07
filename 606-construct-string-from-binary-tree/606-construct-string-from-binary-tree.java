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
    public String tree2str(TreeNode root) {
        String[] ans = new String[1];
        ans[0]="";
        preorder(root,ans);
        return ans[0];
    }
    void preorder(TreeNode root, String ans[]){
        ans[0]+=Integer.toString(root.val);
        if(root.left==null && root.right==null) return;
        
        if(root.left!=null){
            ans[0]+="(";
            preorder(root.left,ans);
            ans[0]+=")";
        }
        if(root.right!=null){
            if(root.left==null) ans[0]+= "()";
            ans[0]+="(";
            preorder(root.right,ans);
            ans[0]+=")";
        }
        return ;
    }
}