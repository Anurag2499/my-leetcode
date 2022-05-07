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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue  = new LinkedList<>();
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size= queue.size();
            List<Integer> level = new ArrayList<>();
            double avg = 0;
            for(int i=0;i<size;i++)
            {
                TreeNode currentnode = queue.remove();
                avg+=currentnode.val;
                
                if(currentnode.left!=null)
                    queue.add(currentnode.left);
                if(currentnode.right!=null)
                    queue.add(currentnode.right);
            }
            avg = avg/size;
            ans.add(avg);
        }
        return ans;
    }
}