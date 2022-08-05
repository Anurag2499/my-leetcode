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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int n= inorder.length;
        for(int i=0;i<n;i++)
        {
            map.put(inorder[i],i);
        }
        TreeNode root = build(inorder, 0,n-1,postorder,0,n-1,map);
        return root;
    }
    private TreeNode build(int[] inorder, int inStart,int inEnd , int[] postorder, int postStart ,int postEnd ,HashMap<Integer,Integer> map ){
        if(inStart>inEnd || postStart>postEnd) return null;
        
        TreeNode root = new TreeNode(postorder[postEnd]);
        int index = map.get(root.val);
        int numInRight =  inEnd - index;
        
        root.left = build(inorder, inStart, index-1, postorder,postStart ,postEnd-numInRight-1,map);
        root.right = build(inorder , index+1,inEnd , postorder , postEnd-numInRight , postEnd-1,map);
        return root;
        
    }
}