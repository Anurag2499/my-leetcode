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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String,Integer> map = new HashMap<>();
        List<TreeNode> ans = new ArrayList<>();
        traverse(root,map,ans);
        return ans;
    }
    private String traverse(TreeNode root,HashMap<String,Integer> map, List<TreeNode> ans){
        if(root==null) return "#";
        
        String curr = root.val + "-"+ traverse(root.left,map,ans) + "-"+ traverse(root.right,map,ans);
        
        if(!map.containsKey(curr)) map.put(curr,1);
        else map.put(curr,map.get(curr)+1);
        
        if(map.get(curr)==2)
            ans.add(root);
        
        return curr;
    }
    
    
}