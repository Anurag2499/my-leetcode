class Solution {
public:
    int kthSmallest(vector<vector<int>>& matrix, int k) {
        int n = matrix[0].size();
       vector<int> r;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                r.push_back(matrix[i][j]);
            }
        }
        sort(r.begin(),r.end());
        
        return r[k-1];
    }
};