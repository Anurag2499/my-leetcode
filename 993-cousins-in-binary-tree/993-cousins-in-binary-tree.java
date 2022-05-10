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
    TreeNode par;
    Pair(TreeNode node, TreeNode par){
        this.node = node;
        this.par = par;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        
        TreeNode parentofx= null;
        TreeNode parentofy= null;

        
        queue.add(new Pair(root,new TreeNode(-1)));
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0;i<size;i++)
            {
                Pair currentobj = queue.remove();
                TreeNode currentnode = currentobj.node;
                TreeNode currentpar =currentobj.par;
                
                if(currentnode.val == x)
                    parentofx = currentpar;
                if(currentnode.val == y)
                    parentofy = currentpar;
                
                if(currentnode.left!=null)
                    queue.add(new Pair(currentnode.left,currentnode));
                if(currentnode.right!=null)
                    queue.add(new Pair(currentnode.right,currentnode));       
            }
            if(parentofx!=null && parentofy!=null)
                return (parentofx.val!=parentofy.val);
            if(parentofx!=null || parentofy!=null)
                return false;
        }
        return false;
    }
}