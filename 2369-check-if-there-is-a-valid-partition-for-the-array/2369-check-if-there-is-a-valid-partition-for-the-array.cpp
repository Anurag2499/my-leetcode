class Solution
{
    public:
        bool validPartition(vector<int> &nums)
        {
            vector<int> dp(nums.size() + 1, -1);
            return isPartition(0, nums, dp);
        }

    bool isPartition(int start, vector<int> &nums, vector<int> &dp)
    {
        // if (start > nums.size())
        //     return false;
        if (start == nums.size())
            return true;
        if (dp[start] != -1)
            return dp[start];
        bool ans1 = false, ans2 = false, ans3 = false;
        if (start + 2 < nums.size() && nums[start] == nums[start + 1] && nums[start + 1] == nums[start + 2])
            ans1 = isPartition(start + 3, nums, dp);

        if (start + 1 < nums.size() && nums[start] == nums[start + 1])
            ans2 = isPartition(start + 2, nums, dp);

        if (start + 2 < nums.size() && nums[start] == nums[start + 1] - 1 && nums[start + 1] == nums[start + 2] - 1)
            ans3 = isPartition(start + 3, nums, dp);

        return dp[start] = ans1 || ans2 || ans3;
    }
};