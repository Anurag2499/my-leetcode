class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int[] contain = new int[1001];
        
        
        //so here index is showing units per boxes and value is showing no of boxes 
        // we are adding because there can be different no. of boxes which have same units per box , so to add them
        for(int i=0;i<boxTypes.length;i++)
        {
            contain[boxTypes[i][1]]+=boxTypes[i][0];
        }
        
        
        
//         we are iterating from backside to get more units
//         newunit is the no. of boxes and i is the unit per box
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