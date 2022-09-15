class Solution {
    public int[] findOriginalArray(int[] changed) {
        int[] arr = new  int[0];
        if(changed.length%2!=0) return arr;
        
        int n = changed.length;
        
        int[] ans = new int[n/2];
        int j=0;
        Arrays.sort(changed);
        
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(changed[i], map.getOrDefault(changed[i],0)+1);
        }
        
        int k=0;
        while(k<n && changed[k]==0){
            k++;
        }
        for(int i=k;i<n;i++){
            if(map.containsKey(changed[i]))
            {
                if(!map.containsKey(2*changed[i])) return arr;
                else{
                    ans[j++]=changed[i];
                    map.put(changed[i],map.get(changed[i])-1);
                    if(map.get(changed[i])==0) map.remove(changed[i]);
                    map.put(2*changed[i],map.get(2*changed[i])-1);
                    if(map.get(2*changed[i])==0) map.remove(2*changed[i]);
                }
            }
        }
        if(ans.length==n/2) return ans;
        return arr;
        
    }
}