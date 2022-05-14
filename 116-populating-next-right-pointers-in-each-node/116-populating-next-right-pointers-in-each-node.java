/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if(root==null)
            return root;
        
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            int size  = queue.size();
            // ArrayList<Node> currentlevel = new ArrayList<>();
            Node prevnode = null;
            for(int i=0;i<size;i++)
            {
                Node currnode = queue.remove();
                if(i!=0)
                    prevnode.next =currnode;
                prevnode =currnode;
                
                // currentlevel.add(currnode);
                if(currnode.left!=null)
                    queue.add(currnode.left);
                if(currnode.right!=null)
                    queue.add(currnode.right);
            }
            
            // for(int i=0;i<size;i++)
            // {
            //     if(i==size-1)
            //         currentlevel.get(i).next=null;
            //     else{
            //         currentlevel.get(i).next = currentlevel.get(i+1);
            //     }    
            // }

        }
        return root;

    }
}