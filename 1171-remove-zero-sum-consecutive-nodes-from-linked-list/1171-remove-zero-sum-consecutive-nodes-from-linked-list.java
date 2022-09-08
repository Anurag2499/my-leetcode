/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int sum=0;
        
        HashMap<Integer, ListNode> map = new HashMap<>();
        map.put(0,dummy);
        
        ListNode curr= head;
        while(curr!=null)
        {
            sum+=curr.val;
            
            if(map.containsKey(sum)){
                
                ListNode prev= map.get(sum).next;
                
                int check = sum+prev.val;
                
                while(check!=sum){
                    map.remove(check);
                    prev=prev.next;
                    check+=prev.val;
                }
                map.get(sum).next = curr.next;
            }
            else{
                map.put(sum,curr);
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}