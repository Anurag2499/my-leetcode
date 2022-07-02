class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        
        int horiMax=0;
        int verMax=0;
        
        
        //firstly we had taken horizontal lines 
        // the max. difference btn 2 lines will ne our horiMax
        // same for vertical lines 
        // then multiply them to get maximum output 
        
        for(int i=0;i<horizontalCuts.length;i++)
        {
            if(i==0)
                horiMax = horizontalCuts[0];
            else
                horiMax = Math.max(horiMax, horizontalCuts[i]-horizontalCuts[i-1]);
        }
        horiMax = Math.max(horiMax, h-horizontalCuts[horizontalCuts.length-1]);

        for(int i=0;i<verticalCuts.length;i++)
        {
            if(i==0)
                verMax = verticalCuts[0];
            else
                verMax = Math.max(verMax, verticalCuts[i]-verticalCuts[i-1]);
        }
        verMax = Math.max(verMax, w-verticalCuts[verticalCuts.length-1]);
        
        // int ans = (verMax*horiMax)%1000000007;
        return (int)((long)verMax * horiMax % 1000000007); 
        
        
    }
}