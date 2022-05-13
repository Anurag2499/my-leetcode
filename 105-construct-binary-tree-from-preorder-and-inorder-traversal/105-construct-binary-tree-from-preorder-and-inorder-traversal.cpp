/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int preindex=0;
    TreeNode* BuildTree(vector<int>& preorder, vector<int>& inorder, int is,int ie)
    {
        if(is>ie)
            return NULL;
        TreeNode* root = new TreeNode(preorder[preindex++]); 
        int index;
        for(int i=is;i<=ie;i++)
        {
            if(inorder[i]==root->val)
            {
                index=i;
                break;
            }   
        }
        root->left = BuildTree(preorder,inorder,is,index-1);
        root->right = BuildTree(preorder,inorder,index+1,ie);
        return root;
    }
    
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        int is=0;
        int ie=preorder.size()-1;
                
        return BuildTree(preorder,inorder,is,ie);
    }
};