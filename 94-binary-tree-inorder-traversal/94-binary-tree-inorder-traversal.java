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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        if(root==null)
            return ans;

        TreeNode curr = root;
        
        while(!stack.isEmpty() || curr!=null)
        {
            while(curr!=null){
                stack.push(curr);
                curr=curr.left;
            }
            TreeNode currentnode = stack.pop();
            ans.add(currentnode.val);
            curr=currentnode.right;
        }
        return ans;
    }
}