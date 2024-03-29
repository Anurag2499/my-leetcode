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
    public boolean isCousins(TreeNode root, int x, int y) {
        int[] parent = new int[2];
        int[] level = new int[2];
        Cousins(root,new TreeNode(-1),0,x,y,parent , level);
        if(parent[0]!=parent[1] && level[0]==level[1]) return true;
        return false;        
    }
    private void Cousins(TreeNode root,TreeNode par,int lev,int x,int y, int[] parent, int[] level)
    {
        if(root==null) return;
        
        if(root.val==x){
            parent[0]= par.val;
            level[0]=lev;
        }
        if(root.val==y){
            parent[1] = par.val;
            level[1] = lev;
        }
        Cousins(root.left,root,lev+1,x,y,parent,level);
        Cousins(root.right,root,lev+1,x,y,parent,level);
        return ;
    }
}