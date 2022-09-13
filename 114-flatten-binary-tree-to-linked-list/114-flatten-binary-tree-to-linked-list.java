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
    public void flatten(TreeNode root) {
        if(root==null) return ;
        // TreeNode ans = root;
        if(root.left==null && root.right==null) return ;
        
        
        Stack<TreeNode> s = new Stack<>();
        // s.push(root);
        if(root.right!=null) s.push(root.right);
        if(root.left!=null) s.push(root.left);
        
        
        TreeNode res=root;
        TreeNode ans=root;
        while(!s.isEmpty())
        {
            TreeNode temp = s.pop();
            
            ans.right=temp;
            ans.left=null;
            ans=ans.right;
            
            if(temp.right!=null)
                s.push(temp.right);
            if(temp.left!=null)
                s.push(temp.left);
        }
        root=ans;
    
    }
}