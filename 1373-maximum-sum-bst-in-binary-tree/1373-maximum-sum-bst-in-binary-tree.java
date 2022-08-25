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
class NodeValue{
    int minNode;
    int maxNode;
    int sum;
    NodeValue(int minNode, int maxNode, int sum){
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.sum = sum;
    }
}
class Solution {
    public NodeValue helper(TreeNode root,int[] maxsum)
    {
        if(root==null) 
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE,0);
        
        if(root.left==null && root.right==null) {
            maxsum[0] = Math.max(maxsum[0],root.val);
            return new NodeValue(root.val,root.val, root.val);
        }
        
        NodeValue left = helper(root.left,maxsum);
        NodeValue right= helper(root.right,maxsum);
        
        if(root.val > left.maxNode && root.val < right.minNode)
        {
            maxsum[0] = Math.max(maxsum[0], left.sum + right.sum + root.val );
            return new NodeValue( Math.min(root.val,left.minNode), Math.max(root.val,right.maxNode), left.sum + right.sum + root.val );
        }
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    public int maxSumBST(TreeNode root) {
        int[] maxsum = new int[1];
        helper(root,maxsum);
        return maxsum[0];
    }
}
