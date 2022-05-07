/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        
        if(root==null)
            return ans;
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                Node currentnode = queue.remove();
                level.add(currentnode.val);
                for(Node current : currentnode.children)
                {
                    queue.add(current);
                }
            }
            ans.add(level);
        }
        return ans;
    }
}