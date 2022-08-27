class Solution {
    public boolean reorderedPowerOf2(int n) {
        int[] freqOfN = countFreq(n);
        
        for(int i=0;i<31;i++)
        {
            int powerof2 = (int)Math.pow(2,i);
            int[] freqOfDigits = countFreq(powerof2);
            if(checkArray(freqOfN , freqOfDigits)) return true;
        }
        return false;
    }
    
    private boolean checkArray(int[] a1, int[] a2){
        for(int i=0;i<10;i++)
        {
            if(a1[i]!=a2[i]) return false;
        }
        return true;
    }
    private int[] countFreq(int n){
        int[] freq = new int[10];
        while(n!=0){
            freq[n%10]++;
            n=n/10;
        }
        return freq;
    }
}