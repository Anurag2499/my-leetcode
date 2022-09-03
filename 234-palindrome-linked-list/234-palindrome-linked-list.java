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
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        if(head.next==null) return true;
        
        while(fast!=null && fast.next!=null&& fast.next.next!=null)
        {
            slow=slow.next;
            fast = fast.next.next;
        }
        
        
        ListNode right = rev(slow.next);
        slow.next=null;
        fast = head;
        
        while(right!=null )
        {
            if(fast.val != right.val) return false;
            fast = fast.next;
            right = right.next;
        }
        return true;
    }
    public ListNode rev(ListNode head)
    {
        ListNode prev= null;
        while(head!=null)
        {
            ListNode next= head.next;
            head.next=  prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}