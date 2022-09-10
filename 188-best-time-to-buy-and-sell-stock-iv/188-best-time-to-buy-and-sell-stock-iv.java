class Solution {
    public int maxProfit(int k, int[] prices) {
        return maxP(prices,0,1,k,new HashMap<>());
    }
    private int maxP(int[] prices, int ci,int canbuy,int trans, HashMap<String,Integer> memo)
    {
        if(ci>=prices.length || trans==0)
            return 0;
        
        int idle=0;
        int profit=0;
        
        String currentKey= ci+"-"+canbuy+"-"+trans;
        if(memo.containsKey(currentKey))
            return memo.get(currentKey);
        
        if(canbuy==1){
            idle = maxP(prices,ci+1,canbuy,trans,memo);
            profit = -prices[ci] + maxP(prices,ci+1,0,trans,memo);
        }
        else{
            idle = maxP(prices,ci+1,canbuy,trans,memo);
            profit = prices[ci]+ maxP(prices,ci+1,1,trans-1,memo);
        }
        memo.put(currentKey,Math.max(profit,idle));
        return Math.max(idle,profit);
    }
}