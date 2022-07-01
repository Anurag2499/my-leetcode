class Solution {
public:
    int findMin(vector<int>& nums) {
//              int lo = 0;
//         int hi = nums.size() - 1;
//         int mid = 0;
        
//         while(lo < hi) {
//             mid = lo + (hi - lo) / 2;
            
//             if (nums[mid] > nums[hi]) {
//                 lo = mid + 1;
//             }
//             else if (nums[mid] < nums[hi]) {
//                 hi = mid;
//             }
//             else { // when num[mid] and num[hi] are same
//                 hi--;
//             }
//         }
//         return nums[lo];
        int l=0;
        int h=nums.size()-1;
        if(nums[l]<=nums[h]) return nums[l];
        while(l<=h)
        {
            int mid = (l+h)/2;
            
//             right check
            if(nums[mid]>nums[mid+1]) return nums[mid+1];
            
//             left check
            else if(nums[mid]<nums[mid-1]) return nums[mid];
            
            else if(nums[l]<=nums[mid]) l=mid+1;
            else if(nums[mid]<=nums[h]) h=mid-1;
        }
        return -1;
        
            
    }
};