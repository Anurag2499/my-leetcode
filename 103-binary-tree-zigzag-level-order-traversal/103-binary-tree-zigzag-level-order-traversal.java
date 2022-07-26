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
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        q.add(root);
        int flag=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> inside = new ArrayList<>();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.remove();
                inside.add(curr.val);
                if(curr.left!=null)
                    q.add(curr.left);
                if(curr.right!=null)
                    q.add(curr.right);
            }
            if(flag==0){
                res.add(inside);
                flag=1;
            }
            else if(flag==1){
                Collections.reverse(inside);
                res.add(inside);
                flag=0;
            }
        }
        return res;
    }
}