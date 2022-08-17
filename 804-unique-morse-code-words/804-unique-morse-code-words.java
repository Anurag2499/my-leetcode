class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] ex = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        HashSet<String> set = new HashSet<>();
        for(String s : words){
            String temp="";
            for(int i=0;i<s.length();i++)
            {
                temp += ex[s.charAt(i)-97];
            }
            set.add(temp);
        }
        return set.size();
    }
}