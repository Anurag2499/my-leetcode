/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node root) {
        if(root==null)
            return null;
        
        Stack<Node> st = new Stack<>();
        Node curr= root;
        Node prev= null;
        while(curr!=null)
        {
            if(curr.child!=null){
                Node child =curr.child;
                if(curr.next!=null){
                    st.add(curr.next);
                    curr.next.prev=null;
                }
                curr.next = child;
                child.prev=curr;
                curr.child=null;
            }
            prev=curr;
            curr=curr.next;
        }
     
        while(!st.isEmpty()){
            curr = st.pop();
            prev.next = curr;
            curr.prev=prev;
            while(curr!=null)
            {
                prev=curr;
                curr=curr.next;
            }
        }
        return root;
        
    }
    
}