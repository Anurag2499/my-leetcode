class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            current.add(nums[i]);
        }
        
        allpermute(nums,0,nums.length-1,current,ans);
        return ans;
    }
    private void allpermute(int[] nums, int start, int end ,List<Integer> current, List<List<Integer>> ans)
    {
        if(start>end)
        {
            ans.add(new ArrayList(current));
            return ;
        }
        
        for(int i=start;i<=end;i++)
        {
            Collections.swap(current,start,i);
            allpermute(nums,start+1,end,current,ans);
            Collections.swap(current,start,i);
        }
        return ;
    }
}