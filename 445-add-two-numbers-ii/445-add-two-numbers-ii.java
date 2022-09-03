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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode a = reverseList(l1);
        ListNode b = reverseList(l2);
        
        int prevcarry = 0;
        int currsum=0;
        ListNode dummynode  = new ListNode(-1);
        ListNode ans=dummynode;
        
        while(a!=null && b!=null){
            currsum = a.val + b.val + prevcarry;
            
            prevcarry  = currsum/10;
            currsum  = currsum%10;
            ans.next  = new ListNode(currsum);
            ans = ans.next;
            a= a.next;
            b=b.next;
        }
        while(a!=null){
            currsum  = a.val  +prevcarry;
            prevcarry = currsum/10;
            currsum=currsum%10;
            ans.next = new ListNode(currsum);
            ans=ans.next;
            a= a.next;
        }
        while(b!=null){
            currsum  = b.val  +prevcarry;
            prevcarry = currsum/10;
            currsum=currsum%10;
            ans.next = new ListNode(currsum);
            ans=ans.next;
            b= b.next;
        }
        if(prevcarry==1){
            ans.next = new ListNode(prevcarry);
        }
        ListNode fin = dummynode.next;
        
        return reverseList(fin);
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