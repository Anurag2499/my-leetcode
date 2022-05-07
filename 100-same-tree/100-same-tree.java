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
    TreeNode p;
    TreeNode q;
    
    Pair(TreeNode p, TreeNode q){
        this.p=p;
        this.q=q;
    }
}
class Solution {
public Boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<Pair> queue = new LinkedList<>();
        
        if(p==null && q==null)
            return true;
    
        queue.add(new Pair(p,q));
        
        while(!queue.isEmpty())
        {
            Pair currentobj = queue.remove();
            TreeNode  t1 = currentobj.p;
            TreeNode t2 = currentobj.q;
            
            if(t1==null || t2==null || t1.val!=t2.val)
                return false;
            
            
            if(t1.left!=null || t2.left!=null)
                queue.add(new Pair(t1.left,t2.left));
            
            if(t1.right!=null || t2.right!=null)
                queue.add(new Pair(t1.right,t2.right));
        }
        return true;
    }
    
}