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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode fast=head;
        ListNode slow = head;
        ListNode prev = null;
        
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        
        prev.next=null;
        ListNode left = head;
        ListNode right = slow;
        
        ListNode leftlist =  sortList(left);
        ListNode rightlist = sortList(right);
        return mergeList(leftlist,rightlist);
    }
    ListNode mergeList(ListNode p1,ListNode p2){
        // ListNode p1 = l;
        // ListNode p2 = r;
        ListNode Rdummy = new ListNode(-1);
        ListNode dummy = Rdummy;
        
        
        while(p1!=null && p2!=null){
            if(p1.val<=p2.val)
            {
                dummy.next= new ListNode(p1.val);
                p1=p1.next;
                dummy=dummy.next;
            }
            else{
                dummy.next= new ListNode(p2.val);
                p2=p2.next;
                dummy=dummy.next;
            }
        }
        if(p1!=null){
            dummy.next=p1;
        }
        if(p2!=null)
            dummy.next=p2;
        
        return Rdummy.next;
    }
}