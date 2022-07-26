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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty())
        {
            List<Integer> l1 = new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode curr = s1.pop();
                l1.add(curr.val);
                if(curr.left!=null)
                    s2.push(curr.left);
                if(curr.right!=null)
                    s2.push(curr.right);
            }
            res.add(l1);
            if(!s2.isEmpty())
            {
            List<Integer> l2 = new ArrayList<>();
            while(!s2.isEmpty())
            {
                TreeNode curr = s2.pop();
                l2.add(curr.val);
                if(curr.right!=null)
                    s1.push(curr.right);
                if(curr.left!=null)
                    s1.push(curr.left);
            }
            res.add(l2);
            }
        }
        return res;        
    }
}