class DLLNode{
    public String url;
    public DLLNode next;
    public DLLNode prev;
    
    DLLNode(String url){
        this.url=url;
    }
}
class BrowserHistory {
    DLLNode head = null;
    DLLNode iterator = head;

    public BrowserHistory(String homepage) {
        head = new DLLNode(homepage);
        iterator = head;
        
    }
    
    public void visit(String url) {
        DLLNode newNode = new DLLNode(url);
        iterator.next = newNode;
        newNode.prev=iterator;
        iterator=newNode;
        
    }
    
    public String back(int steps) {
        
        while(iterator.prev!=null && steps>0){
            iterator=iterator.prev;
            steps-=1;
        }
        return iterator.url;
    }
    
    public String forward(int steps) {
         while(iterator.next!=null && steps!=0){
             iterator=iterator.next;
             steps-=1;
         }
        return iterator.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */