/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    private void parenting(TreeNode root, HashMap<TreeNode ,TreeNode> parentMap)
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode curr = q.poll();
            if(curr.left!=null)
            {
                parentMap.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right!=null)
            {
                parentMap.put(curr.right, curr);
                q.add(curr.right);
            }
        }
    }
    
    
    
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode ,TreeNode> parentMap = new HashMap<>();
        parenting(root,parentMap);
        
        int currdist = 0;
        HashMap<TreeNode ,Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        while(!q.isEmpty())
        {
            if(currdist==k)
                break;
            
            int size= q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr = q.poll();
                visited.put(curr,true);
                if(curr.left!=null && visited.get(curr.left)==null)
                {
                    q.add(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null)
                {
                    q.add(curr.right);
                    visited.put(curr.right,true);
                }
                if(parentMap.get(curr)!=null && visited.get(parentMap.get(curr))==null){
                    q.add(parentMap.get(curr));
                    visited.put(parentMap.get(curr),true);
                }
            }
            currdist++;
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            ans.add(curr.val);
        }
        return ans;
        
    }
}