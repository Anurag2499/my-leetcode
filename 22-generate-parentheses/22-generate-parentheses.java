class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        allcomb(0,0,"",n,ans);
        return ans;
    }
    private void allcomb(int opencount, int closecount, String currentString, int n ,List<String> ans)
    {
        if(opencount==closecount && opencount==n)
        {
            ans.add(currentString);
        }
        
        if(opencount<n)
        {
            allcomb(opencount+1,closecount,currentString+"(",n,ans);
        }
        if(opencount>closecount)
        {
            allcomb(opencount,closecount+1,currentString+")",n,ans);
        }
        return;
    }
}