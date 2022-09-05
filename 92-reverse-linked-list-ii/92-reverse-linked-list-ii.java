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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next=head;
        ListNode prevdummy=dummy;
        ListNode prev = null;
        ListNode curr=head;
        
        for(int i=1;i<left;i++){
            prevdummy=prevdummy.next;
            curr=curr.next;
        }
        
        while(left<=right){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
            left++;
        }
        ListNode temp = prevdummy.next;
        prevdummy.next=prev;
        temp.next = curr;
        
        return dummy.next;
        
    }
}