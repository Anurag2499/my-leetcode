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
        for(int i=0;i<n-1;i++){
            curr=curr.next;
        }
        while(curr!=null && curr.next!=null){
            curr=curr.next;
            prev=prev.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
        
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        
        
        while(head!=null){
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}