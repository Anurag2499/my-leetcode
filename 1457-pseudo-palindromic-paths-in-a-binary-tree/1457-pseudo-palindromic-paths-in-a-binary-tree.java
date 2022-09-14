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
    int ans=0;
    public int pseudoPalindromicPaths (TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        preorder(root,map);
        return ans;
    }
    
    void preorder(TreeNode root,HashMap<Integer,Integer> map ){
        if(root==null) return ;
        
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        
        if(root.left==null && root.right==null)
        {
            int odd=0;
            for(Integer i: map.keySet()){
                if(map.get(i)%2==1) odd++;
            }
            if(odd<=1) ans++;
            
            map.put(root.val, map.get(root.val)-1);
            return ;
        }
        preorder(root.left,map);
        preorder(root.right,map);
        
        map.put(root.val,map.get(root.val)-1);
        return ;
    }
}