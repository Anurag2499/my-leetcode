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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root,ans);
        Collections.sort(ans);
        return ans.get(k-1);
    }
    private void dfs(TreeNode root, ArrayList<Integer> ans)
    {
        if(root==null) return ;
        ans.add(root.val);
        dfs(root.left,ans);
        dfs(root.right,ans);
        return ;
    }
}