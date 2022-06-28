class Solution {
    public int minDeletions(String s) {
        int count = 0;
        int[] letterCounts = new int[26];
        
        for(char c : s.toCharArray()){ 
            letterCounts[c-'a']++;
        }
        
        Set<Integer> set = new HashSet<Integer>();
        for(int c : letterCounts){
            while(c != 0 && !set.add(c--)){
                count++;
            }
        }  
        
        return count;
    }

}