class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] contain = new int[1001];
        
        for(int i=0;i<boxTypes.length;i++)
        {
            contain[boxTypes[i][1]]+=boxTypes[i][0];
        }
        
        int ans=0;
        for(int i=1000;i>=0;i--)
        {
            if(contain[i]==0)
                continue;
            
            int newunit = Math.min(contain[i],truckSize);
            if(newunit==truckSize)
            {
                ans+=newunit*i;
                break;
            }
            else{
                truckSize= truckSize-newunit;
                ans+= newunit*i;
            }
        }
        return ans;
    }
}