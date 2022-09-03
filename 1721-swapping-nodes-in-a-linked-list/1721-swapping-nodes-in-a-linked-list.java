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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode curr=head;
        ListNode first = head;
        ListNode second = head;
        
        for(int i=0;i<k;i++){
            curr=curr.next;
        }
        while(curr!=null){
            curr=curr.next;
            second=second.next;    //reached the kth node backside
        }
        
        for(int i=0;i<k-1;i++){
            first=first.next;
        }
        int temp = first.val;
        first.val = second.val;
        second.val=temp;
        return head;
    }
}