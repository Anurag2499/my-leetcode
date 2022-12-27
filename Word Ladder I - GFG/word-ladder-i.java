//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends

class Pair{
    String first;
    int second;
    Pair(String first, int second)
    {
        this.first = first;
        this.second = second;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        
        HashSet<String> set =new HashSet<>();
        
        for(String s: wordList) set.add(s);
        while(!q.isEmpty())
        {
            Pair p = q.remove();
            String word = p.first;
            int lad = p.second;
            
            if(word.equals(targetWord)) return lad;
            
            for(int i=0;i<word.length();i++)
            {
                char[] wordArr = word.toCharArray();
                for(char ch='a';ch<='z';ch++)
                {
                    wordArr[i] = ch;
                    String backtoString = new String(wordArr);
                    
                    if(set.contains(backtoString)){
                        q.add(new Pair(backtoString,lad+1));
                        set.remove(backtoString);
                    }
                }
            }
        }
        return 0;
        
    }
}



















