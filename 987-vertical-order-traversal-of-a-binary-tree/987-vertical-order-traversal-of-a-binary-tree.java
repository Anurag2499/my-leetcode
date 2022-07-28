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
class Tuple{
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode node, int col,int row){
        this.node =node;
        this.col=col;
        this.row =row;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Queue<Tuple> q = new LinkedList<>();
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        
        q.add(new Tuple(root,0,0));
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0;i<size;i++)
            {
                Tuple t = q.poll();
                TreeNode curr = t.node;
                int x = t.col;
                int y = t.row;
                
                if(!map.containsKey(x)){
                    map.put(x,new TreeMap<>());
                }
                if(!map.get(x).containsKey(y))
                {
                    map.get(x).put(y,new PriorityQueue<Integer>());
                }
                
                map.get(x).get(y).add(curr.val);
                
                if(curr.left!=null)
                {
                    q.add(new Tuple(curr.left, x-1,y+1));
                }
                if(curr.right!=null)
                {
                    q.add(new Tuple(curr.right,x+1,y+1));
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> row : map.values()){
            List<Integer> temp = new ArrayList<>();
            for(PriorityQueue<Integer> l : row.values())
            {
                while(!l.isEmpty())
                {
                    temp.add(l.poll());
                }
            }
            ans.add(temp);
        }
        return ans;
        
    }
}
















