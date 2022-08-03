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
class Pair{
    TreeNode node;
    int index;
    Pair(TreeNode node,int index){
        this.node=node;
        this.index=index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans=1;
        
        q.add(new Pair(root,1));
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> l = new ArrayList<>();
           
            for(int i=0;i<size;i++)
            {
                Pair pair = q.poll();
                TreeNode curr = pair.node;
                int currIndex = pair.index;
                
                l.add(currIndex);
                
                if(curr.left!=null)
                {
                    q.add(new Pair(curr.left, 2*currIndex));
                }
                if(curr.right!=null)
                {
                    q.add(new Pair(curr.right, 2*currIndex+1));
                }
            }
            ans = Math.max(ans,(l.get(l.size()-1)-l.get(0)+1));
            
        }
        return ans;
        
    }
}