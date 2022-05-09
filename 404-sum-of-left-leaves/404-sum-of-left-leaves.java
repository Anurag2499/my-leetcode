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
class Pair {
    TreeNode node;
    Boolean left;
    Pair(TreeNode node, boolean left)
    {
        this.node= node;
        this.left=left;
    }
}
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        int total=0;
        
        queue.add(new Pair(root,false));
        
        while(!queue.isEmpty()){
            Pair currentobj = queue.remove();
            TreeNode currentnode = currentobj.node;
            boolean isLeft = currentobj.left;
            
            if(currentnode.left==null && currentnode.right==null && isLeft)
                total+=currentnode.val;
            
            if(currentnode.left!=null)
                queue.add(new Pair(currentnode.left,true));
            if(currentnode.right!=null)
                queue.add(new Pair(currentnode.right,false));
        }
        return total;
        
    }
}