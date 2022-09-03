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
        int prevcarry = 0;
        int currsum=0;
        ListNode dummynode  = new ListNode(-1);
        ListNode ans=dummynode;
        
        while(l1!=null && l2!=null){
            currsum = l1.val + l2.val + prevcarry;
            
            prevcarry  = currsum/10;
            currsum  = currsum%10;
            ans.next  = new ListNode(currsum);
            ans = ans.next;
            l1= l1.next;
            l2=l2.next;
        }
        while(l1!=null){
            currsum  = l1.val  +prevcarry;
            prevcarry = currsum/10;
            currsum=currsum%10;
            ans.next = new ListNode(currsum);
            ans=ans.next;
            l1= l1.next;
        }
        while(l2!=null){
            currsum  = l2.val  +prevcarry;
            prevcarry = currsum/10;
            currsum=currsum%10;
            ans.next = new ListNode(currsum);
            ans=ans.next;
            l2= l2.next;
        }
        if(prevcarry==1){
            ans.next = new ListNode(prevcarry);
        }
        return dummynode.next;
        
    }
}