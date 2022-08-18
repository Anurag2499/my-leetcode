class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int  n =arr.length;
        for(int i=0;i<arr.length;i++)
        {
            if(map.containsKey(arr[i])) map.put(arr[i],map.get(arr[i])+1);
            else map.put(arr[i],1);
        }
        // int[] a = new int[map.size()];
        ArrayList<Integer> a = new ArrayList<>();
        
        for (Integer i : map.values())
        {
            a.add(i);
        }
        
        Collections.sort(a, Collections.reverseOrder());
        
        int ans=0;
        int sum=0;
        for(int i=0;i<map.size();i++)
        {
            sum+=a.get(i);
            ans++;
            if(sum>=n/2)
                return ans;
        }
        return ans;
    }
    
    
}