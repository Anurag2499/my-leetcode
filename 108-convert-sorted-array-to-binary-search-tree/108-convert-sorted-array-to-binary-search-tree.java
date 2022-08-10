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
    public TreeNode sortedArrayToBST(int[] nums) {
        
        return bst(nums,0,nums.length-1);
        
        
    }
    private TreeNode bst(int[] nums, int i, int j)
    {
        int mid = (i+j+1)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        if(mid>i){
            root.left = bst(nums,i,mid-1);
        }
        // else{
        //     root.left=null;
        // }
        if(mid<j)
            root.right = bst(nums,mid+1,j);
        // else{
        //     root.right=null;
        // }
        return root;
    }
}