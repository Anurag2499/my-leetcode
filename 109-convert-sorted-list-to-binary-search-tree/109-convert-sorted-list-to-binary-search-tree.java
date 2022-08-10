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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        int size=0;
        while(head!=null)
        {
            arr.add(head.val);
            size+=1;
            head= head.next;
        }
        if(size==0) return null;
        return bst(arr,0,size-1);
    }
    private TreeNode bst(ArrayList<Integer> nums, int i, int j)
    {
        int mid = (i+j+1)/2;
        
        TreeNode root = new TreeNode(nums.get(mid));
        if(mid>i){
            root.left = bst(nums,i,mid-1);
        }
        else{
            root.left=null;
        }
        if(mid<j)
            root.right = bst(nums,mid+1,j);
        else{
            root.right=null;
        }
        return root;
    }
}