/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow =head;
        ListNode fast=head;
        
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow = slow.next;
            if(slow==fast) break;
        }
        if(fast==null ||fast.next==null) return null;
        
        fast=head;
        if(slow==head) return slow;
        while(fast!=slow){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
            
//         Set<ListNode> set = new HashSet<>();
//         if(head==null) return null;
        
//         ListNode curr= head;
//         while(curr!=null){
//             if(set.contains(curr)) return curr;
//             set.add(curr);
//             curr=curr.next;
//         }
//         return null;
            
    }
}