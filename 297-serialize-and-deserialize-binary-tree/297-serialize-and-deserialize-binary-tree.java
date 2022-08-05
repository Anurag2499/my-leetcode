/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        // String ans="";
        q.add(root);
        while(!q.isEmpty())
        {
            TreeNode temp = q.poll();
            if(temp==null) {
                ans.append("n ");
                continue;
            }
            // String v = Integer.toString(temp.val);
            ans.append(temp.val + " ");
            q.add(temp.left);
            q.add(temp.right);
        }
        // System.out.print(ans);
        return ans.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") return null;
        Queue<TreeNode> q = new LinkedList<>();
        
        String[] str = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(str[0]));
       
        q.add(root);
        for(int i=1;i<str.length;i++)
        {
            TreeNode curr = q.poll();
            if(!str[i].equals("n")){
                TreeNode left= new TreeNode(Integer.parseInt(str[i])); 
                curr.left = left;
                q.add(left);
            }
            else{
                curr.left=null;
            }
            if(!str[++i].equals("n")){
                TreeNode right = new TreeNode(Integer.parseInt(str[i])); 
                curr.right = right;
                q.add(right);
            }
            else{
                curr.right=null;
            }
        }
        return root;
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));