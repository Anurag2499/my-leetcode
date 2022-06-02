class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        allsub(nums,0,new ArrayList<Integer>(),nums.length,ans);
        List res = new ArrayList(ans);
        return res;
            
    }
    private void allsub(int[] nums,int ci,ArrayList<Integer> currentsubset, int n,Set<List<Integer>> ans)
    {
        if(ci==n)
        {
            if((currentsubset.size()>1))
            {
                ans.add(new ArrayList<Integer>(currentsubset));
            }
            return;
        }
        
        if(currentsubset.size()==0 || currentsubset.get(currentsubset.size()-1)<=nums[ci] )
        {
            currentsubset.add(nums[ci]);
            allsub(nums,ci+1,currentsubset,n,ans);
            currentsubset.remove(currentsubset.size()-1);
        }
       
        allsub(nums,ci+1,currentsubset,n,ans);
        
        return ;
        
    }
}