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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        path(root,targetSum,ans,0,in);
        return ans;
    }
    void path(TreeNode root, int target,List<List<Integer>> ans,int cur, List<Integer> inList )
    {
        if(root==null) return ;
        
        inList.add(root.val);
        cur+=root.val;
        if(cur==target && root.left==null && root.right==null)
        {
            ans.add(new ArrayList(inList));
            inList.remove(inList.size()-1);
            return;
        }
        
        path(root.left,target,ans,cur,inList);
        // inList.remove(inList.size()-1);
        path(root.right,target,ans,cur,inList);
        inList.remove(inList.size()-1);
        return ;
    }
}