class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String,Integer> memo = new HashMap<>();
        
        for(int i=0;i<words1.length;i++)
        {
            if(memo.containsKey(words1[i]))
            {
                memo.put(words1[i],memo.get(words1[i])+1);
            }
            else
            {
                memo.put(words1[i],1);
            }
        }
        int res=0;
        for(int i=0;i<words2.length;i++)
        {
            Integer freq=memo.get(words2[i]);
            
            if(freq!=null && freq<=1)     //if freq is more than 2 than it is not valid 
            {                                       // lets see in both words freq is 2 2 then also count will be zero 
                memo.put(words2[i],freq-1);           // and we will add to our ans.
            }
            
        }
        
        for(Integer count : memo.values())
        {
            if(count==0)
                res+=1;
        }
        return res;
    }
}