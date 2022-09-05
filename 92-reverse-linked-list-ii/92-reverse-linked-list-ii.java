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
        
        ListNode prev = dummy;
        ListNode curr=head;
        
        for(int i=1;i<left;i++){
            prev=curr;
            curr=curr.next;
        }
        
        //curr -> 2
        //prev-> 1
        
        prev.next = reverseList(curr,right-left+1);
        return dummy.next;
        
    }
    ListNode reverseList(ListNode l,int n){
        ListNode curr = l;
        ListNode prev=null;
        
        for(int i=0;i<n;i++){
            ListNode temp = curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        l.next = curr;
        return prev;
    }
}