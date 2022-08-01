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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        
        TreeMap<Integer,Integer> map = new TreeMap<>();
        right(root,0,map,ans);
        // for(Integer val : map.values()){
        //     ans.add(val);
        // }
        return ans;
    }
    private void right(TreeNode root,int level,TreeMap<Integer,Integer> map,List<Integer> ans)
    {
        if(root==null)
            return ;
        // if(!map.containsKey(i)){
        //     map.put(i,root.val);
        // }
        if(level==ans.size()){
            ans.add(root.val);
        }
        right(root.right,level+1,map,ans);
        right(root.left,level+1,map,ans);
        return ;
    }
}