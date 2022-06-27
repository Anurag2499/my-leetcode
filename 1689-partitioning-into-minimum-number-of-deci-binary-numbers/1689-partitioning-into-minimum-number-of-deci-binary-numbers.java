class Solution {
    public int minPartitions(String n) {
        int s= n.length();
        
        int maxv=0;
        for(int i=0;i<s;i++)
        {
            int val = Character.getNumericValue(n.charAt(i));
            if(val>maxv)
                maxv=val;
        }
        return maxv;
    }
}