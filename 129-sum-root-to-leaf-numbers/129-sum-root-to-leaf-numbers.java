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
        // int[] ans = new int[1];
        // sum(root,"",ans);
        // return ans[0];
        
        int ans=0;
        String s="";
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,s+Integer.toString(root.val)));
        while(!q.isEmpty())
        {
            Pair p = q.poll();
            TreeNode curr = p.node;
            String st = p.str;
            if(curr.left==null && curr.right==null) {
                ans+=Integer.parseInt(st);
                continue;
            }
            if(curr.left!=null){
                q.add(new Pair(curr.left, st+Integer.toString(curr.left.val)));
            }
            if(curr.right!=null){
                q.add(new Pair(curr.right, st+Integer.toString(curr.right.val)));
            }
        }
        return ans;
    }
//     private void sum(TreeNode root, String s, int[] ans)
//     {
//         if(root==null) return ;
        
//         s+=Integer.toString(root.val);
        
//         if(root.left!=null)
//             sum(root.left, s,ans);
        
//         if(root.right!=null)
//             sum(root.right,s,ans);
//         ans[0]+=Integer.parseInt(s);
//         return;
        
//     }
}