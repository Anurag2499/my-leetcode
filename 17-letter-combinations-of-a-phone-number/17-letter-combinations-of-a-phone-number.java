class Solution {
    private static final String[] Key_Mapping ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {            
        List<String> ans = new ArrayList<>();
        if(digits.length()==0)
            return ans;

        combinations(digits,0,"",ans);
        return ans;
    }
    
    private void combinations(String digits, int currentIndex,String currentString, List<String> ans)
    {
        if(currentIndex>=digits.length()){
            ans.add(currentString);
            return ;
        }
        
        String letters = Key_Mapping[digits.charAt(currentIndex)-'0'];
        
        for(int i=0;i<letters.length();i++)
        {
            combinations(digits,currentIndex+1,currentString+letters.charAt(i),ans);
        }
        return ;
    }
}