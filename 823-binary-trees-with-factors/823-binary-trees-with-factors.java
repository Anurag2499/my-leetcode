class Solution {
    HashMap<Integer,Long> memo = new HashMap<>();
    public int numFactoredBinaryTrees(int[] arr) 
    {
        Set<Integer> set = new HashSet<>();
        for(Integer i : arr)
            set.add(i);
        
        long ans=0;
        for(Integer num: arr){
            ans+= count(num,set);
            ans%=1000000007;
        }
        return (int)ans%1000000007;
    }
    private long count(int num, Set<Integer> set)
    {
        long count=1;
        
        if(memo.containsKey(num)){
            return memo.get(num);
        }
        
        for(Integer x:set)
        {
            if(num%x==0 && set.contains(num/x))
            {
                count+= (count(x,set) * count(num/x,set));
                count%=1000000007;
            }
        }
        memo.put(num,count);
    
        return count;
    }
}