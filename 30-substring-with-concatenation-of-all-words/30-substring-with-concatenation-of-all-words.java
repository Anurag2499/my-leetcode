// class Solution{
// public List<Integer> findSubstring(String s, String[] words) {
//         List<Integer> indices = new ArrayList<>();
//         Map<String, Integer> wordsMap = new HashMap<>();
//         Arrays.stream(words).forEach(word -> wordsMap.put(word, wordsMap.getOrDefault(word, 0) + 1));

//         int wordLength = words[0].length(), count = words.length;
//         for (int index = 0; index <= s.length() - wordLength * count; ++index) {
//             if (isContainsAllWords(wordsMap, s.substring(index, index + wordLength * count), wordLength))
//                 indices.add(index);
//         }

//         return indices;
//     }

//     private boolean isContainsAllWords(Map<String, Integer> wordsMap, String substring, int wordLength) {
//         Map<String, Integer> substringWordsMap = new HashMap<>();
//         for (int i = 0; i < substring.length(); i += wordLength) {
//             String word = substring.substring(i, i + wordLength);
//             substringWordsMap.put(word, substringWordsMap.getOrDefault(word, 0) + 1);
            
// 			if (substringWordsMap.get(word) > wordsMap.getOrDefault(word, 0))
//                 return false;
//         }
//         return substringWordsMap.equals(wordsMap);
//     }
// }
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String,Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        
        for(String i:words)
        {
            if(map.containsKey(i))
                map.put(i,map.get(i)+1);
            else
                map.put(i,1);
        }
        
        // int count = map.size();
        
        String w = words[0];
        int size = w.length();
        int k= w.length() * words.length; 
        int i=0;
        while(i+k <= s.length())
        {
            String st = s.substring(i,i+k);
            if(checksubstring(st,map,size))
                res.add(i);
            i++;
        }
        return res;
           
    }
        private boolean checksubstring(String s, HashMap<String,Integer> map, int size)
        {
            // int i=0;
            // int j=size;
            // int count = map.size();
            HashMap<String, Integer> copymap = new HashMap<>(map);
            
            for(int i=0;i<s.length();i+=size)
           {
                String st = s.substring(i,i+size);
                if(copymap.containsKey(st))
                {
                    if(copymap.get(st)<=0) return false;
                    if(copymap.get(st)>0){
                        copymap.put(st,copymap.get(st)-1);
                    }
                }
                else{
                    return false;
                }
            }
            return true;
        }
}







