class Solution {
    public boolean reorderedPowerOf2(int n) {
        String temp = Integer.toString(n);
        int[] num = new int[temp.length()];
        for (int i = 0; i < temp.length(); i++)
        {
            num[i] = temp.charAt(i) - '0';
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // if (num.length ==0) return ans;
        List<Integer> l0 = new ArrayList<Integer>();
        l0.add(num[0]);
        ans.add(l0);
        for (int i = 1; i< num.length; ++i){
            List<List<Integer>> new_ans = new ArrayList<List<Integer>>(); 
            for (int j = 0; j<=i; ++j){            
                for (List<Integer> l : ans){
        	        List<Integer> new_l = new ArrayList<Integer>(l);
        	        new_l.add(j,num[i]);
        	        new_ans.add(new_l);
                }
                }
                ans = new_ans;
        }
        List<Integer> allper = new ArrayList<>();
        for(List<Integer> li : ans)
        {
            int val=0;
            for(int i=0;i<li.size();i++){
                if(i==0 && li.get(i)==0) break;
                val=val*10 + li.get(i);
            }
            allper.add(val);
        }
        for(Integer i : allper){
            if(power(i)) return true;
        }
        return false;

    }
    public boolean power(int n){
        if((n!=0) && (n&(n-1))==0) return true;
        // ((x & (x - 1)) == 0)
        return false;
    }
}