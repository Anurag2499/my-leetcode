class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String,Integer> memo = new HashMap<>();
        
        for(String word : arr)
        {
            if(memo.containsKey(word))
            {
                memo.put(word,memo.get(word)+1);
            }
            else
                memo.put(word,1);
        }
        
        int temp=1;
        for(String word : arr)
        {
            if(memo.get(word)==1 && temp ==k)
                return word;
            
            if(memo.get(word)==1)
                temp+=1;
        }
        return "";
    }
}