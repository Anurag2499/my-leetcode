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
        ArrayList<Integer> list = new ArrayList<>();
        
        while(head!=null)
        {
            list.add(head.val);
            head= head.next;
        }
        int j = list.size()-1;
        int i=0;
        while(j>i)
        {
            if(list.get(i)!=list.get(j)) return false;
            j--;
            i++;
        }
        return true;
    }
}