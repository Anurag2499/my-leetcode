class Node{
    int key;
    int val;
    Node next;
    Node prev;
    Node(int key, int val){
        this.key = key;
        this.val= val;
    }
}

class LRUCache {
    Node head= new Node(-1,-1);
    Node tail= new Node(-1,-1);
    int cap;
    
    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }
    
    void add(Node newNode){
        Node temp = head.next;
        newNode.next= temp;
        newNode.prev=head;
        head.next=newNode;
        temp.prev = newNode;
    }
    
    void delete(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;
        node.next=null;
        node.prev=null;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int res = resNode.val;
            map.remove(key);
            delete(resNode);
            add(resNode);
            map.put(key, head.next);
            return res;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node existingNode = map.get(key);
            map.remove(key);
            delete(existingNode);
        }
        if(map.size()==cap){
            map.remove(tail.prev.key);
            delete(tail.prev);
        }
        add(new Node(key,value));
        map.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */