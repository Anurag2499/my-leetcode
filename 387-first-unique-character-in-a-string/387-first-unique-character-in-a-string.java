class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> memo = new HashMap<>();
        char st[] = s.toCharArray();
        for(char c : st)
        {
            if(memo.containsKey(c)) memo.put(c,memo.get(c)+1);
            else memo.put(c,1);
        }
        for(int i=0;i<s.length();i++)
        {
            if(memo.get(s.charAt(i))==1)
               return i;
        }
    
        return -1;
    }
}