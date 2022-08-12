/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null) return null;
        // if(root==p || root==q) return root;
        
        TreeNode ans = root;
        if(p.val<root.val && q.val<root.val) 
            ans = lowestCommonAncestor(root.left,p,q);
        else if(p.val>root.val && q.val>root.val)
            ans=lowestCommonAncestor(root.right,p,q);
        else{
            return root;
        }
        return ans;
    }
}
    
//         ArrayList<Integer> p1 = new ArrayList<>();
//         ArrayList<Integer> p2 = new ArrayList<>();
        
//         path(root,p,p1);
//         path(root,q,p2);
//         int i=0;
//         TreeNode res = new TreeNode(-1);
//         while(i<(Math.min(p1.size(),p2.size())))
//         {
//             if(p1.get(i)==p2.get(i)) res = new TreeNode(p1.get(i));
//             if(p1.get(i)!=p2.get(i)) return res;
//             i++;
//         }
//         return res;
        
    // }
//     private Boolean path(TreeNode root, TreeNode p, ArrayList<Integer> p1)
//     {
//         if(root==null) return false;
        
//         p1.add(root.val);
        
//         if(root==p) return true;
        
//         if(path(root.left,p,p1) || path(root.right,p,p1))
//             return true;
        
//         p1.remove(p1.size()-1);
//         return false;
//     }
// }