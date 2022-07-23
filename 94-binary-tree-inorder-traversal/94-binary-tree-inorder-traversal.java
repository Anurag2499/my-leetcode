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
        Stack<TreeNode> st = new Stack<>();
        if(root==null) return ans;
        
        TreeNode curr = root;
        while(!st.isEmpty() || curr!=null)
        {
            while(curr!=null)
            {
                st.push(curr);
                curr=curr.left;
            }
            TreeNode temp = st.pop();
            ans.add(temp.val);
            curr= temp.right;
        }
        return ans;
        
    }
}