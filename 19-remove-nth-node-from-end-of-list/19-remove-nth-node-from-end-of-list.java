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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        ListNode dummy=new ListNode(-1);
        dummy.next = head;
        ListNode prev=dummy;
        
        //we have to reach on the nth node .. firstly it is on 1st node thats why (n-1)
        for(int i=0;i<n;i++){
            curr=curr.next;
        }
        
        while(curr!=null ){
            curr=curr.next;
            prev=prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
        
    }

}