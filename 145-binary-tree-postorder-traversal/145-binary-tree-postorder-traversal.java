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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        
        if(root==null)
            return ans;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp = st.pop();
            ans.add(temp.val);
            
            if(temp.left!=null)
                st.push(temp.left);
            if(temp.right!=null)
                st.push(temp.right);
        }
        Collections.reverse(ans);
        return ans;
    }
}