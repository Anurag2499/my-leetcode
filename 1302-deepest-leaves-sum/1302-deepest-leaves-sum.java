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
    public int deepestLeavesSum(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode currentnode = queue.remove();
                level.add(currentnode.val);
                if(currentnode.left!=null)
                    queue.add(currentnode.left);
                if(currentnode.right!=null)
                    queue.add(currentnode.right);
            }
            ans.add(level);
        }
        int index = ans.size();
        List<Integer> l = ans.get(index-1);
        int res=0;
        for(Integer i : l){
            res+=i;
        }
        return res;
    }
}