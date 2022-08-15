class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        int count=1;
        int n=nums.size();
        
        if(n==1) return 1;
        int i=0;
        int j=1;
        while(j<n)
        {
            if(nums[j]!=nums[i])
            {
                i++;
                nums[i]=nums[j++];
            }
            else{
                j++;
            }
        }
        return i+1;
        
//         for(int i=1;i<n;i++)
//         {
//             if(nums[i]==nums[i-1])
//                 count++;
//             else
//                 nums[i-count]=nums[i];
//         }
//         return n-count;
    }
};