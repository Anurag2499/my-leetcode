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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null) return head;
        
        ListNode curr = head;
        int size=1;
        while(curr.next!=null)
        {
            size++;
            curr=curr.next;
        }
        curr.next=head;
        
        k=k%size;
        
        ListNode temp = head;
        for(int i=0;i<size-k-1;i++)
        {
            // prev.next;
            temp=temp.next;
        }
        ListNode newHead = temp.next;
        temp.next=null;
        
        return newHead;
        
    }
}