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
class Pair{
    TreeNode node;
    String str;
    Pair(TreeNode node,String str){
        this.node=node;
        this.str=str;
    }
}
class Solution {
    
    public int sumNumbers(TreeNode root) {
        
        return sum(root,0);
        
        
//         ******Level Order*******
        // int ans=0;
        // String s="";
        // Queue<Pair> q = new LinkedList<>();
        // q.add(new Pair(root,s+Integer.toString(root.val)));
        // while(!q.isEmpty())
        // {
        //     Pair p = q.poll();
        //     TreeNode curr = p.node;
        //     String st = p.str;
        //     if(curr.left==null && curr.right==null) {
        //         ans+=Integer.parseInt(st);
        //         continue;
        //     }
        //     if(curr.left!=null){
        //         q.add(new Pair(curr.left, st+Integer.toString(curr.left.val)));
        //     }
        //     if(curr.right!=null){
        //         q.add(new Pair(curr.right, st+Integer.toString(curr.right.val)));
        //     }
        // }
        // return ans;
    }
    private int sum(TreeNode root, int s)
    {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return s*10+root.val;
        return sum(root.left,s*10+root.val) + sum(root.right,s*10+root.val);
        
    }
}