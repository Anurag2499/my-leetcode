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
    public boolean findTarget(TreeNode root, int k) {
        HashMap<Integer,Integer> memo = new HashMap<>();
        
        return check(root,k,memo);
        
    }
    private boolean check(TreeNode root, int k ,HashMap<Integer,Integer> memo)
    {
        if(root==null) return false;
        
        if(memo.containsKey(k-root.val)){
            return true;
        }
        memo.put(root.val,1);
        return check(root.left,k,memo) || check(root.right,k,memo);
    }
}