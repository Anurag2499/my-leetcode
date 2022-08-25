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
    int i=0;
    public void recoverTree(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        store(root,list);
        Collections.sort(list);
        
        traverse(root, list);
        return ;
        
    }
    public void traverse(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null) return;
        traverse(root.left, list);
        if(list.get(i)!=root.val) root.val= list.get(i);
        i++;
        
        traverse(root.right,list);
        return ;
    }
    
    
    
    
    
    public void store(TreeNode root, ArrayList<Integer> list)
    {
        if(root==null) return ;
        store(root.left,list);
        list.add(root.val);
        store(root.right,list);
        return ;
    }
}