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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null)
            return ans;
        
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode currentnode = stack.pop();
            ans.add(currentnode.val);
            
            if(currentnode.right!=null)
                stack.push(currentnode.right);
            
            if(currentnode.left!=null)
                stack.push(currentnode.left);
        }
        return ans;
    }
}