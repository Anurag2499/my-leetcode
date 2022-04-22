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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        path(root,ans,""+Integer.toString(root.val));
        return ans;
            
    }
    private void path(TreeNode root,List<String> ans,String currents)
    {
        if(root.left==null && root.right==null)
        {    ans.add(currents);
             return;
        }
        
        
        if(root.left!=null)
            path(root.left,ans,currents+"->"+Integer.toString(root.left.val));
        
        if(root.right!=null)
            path(root.right,ans,currents+"->"+Integer.toString(root.right.val));
        
        return ;
        
    }
}