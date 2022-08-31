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
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        
        int l=0;
        int h = arr.size()-1;
        
        return build(arr,l,h);
    }
    TreeNode build(List<Integer> arr, int l,int h){
        if(l>h){
            return null;
        }
        int mid = (l+h)/2;
    
        TreeNode root = new TreeNode(arr.get(mid));
        
        int lstart = l;
        int lend = mid-1;
        int rstart = mid+1;
        int rend = h;
        
        root.left = build(arr,lstart,lend);
        root.right = build(arr,rstart,rend);
        
        return root;
    }
    void inorder(TreeNode root, List<Integer> arr){
        if(root==null){
            return ;
        }
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
        return ;
    }
}