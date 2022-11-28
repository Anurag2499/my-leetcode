class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        int n = matches.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // putting all the elements in the hashmap--- for the winner add the element
        // with value 0
        // for the loser add the element with the +1;
        for (int i = 0; i < n; i++) {
            map.put(matches[i][1], map.getOrDefault(matches[i][1], 0) + 1);
            map.put(matches[i][0], map.getOrDefault(matches[i][0], 0) + 0);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == 0)
                ans.get(0).add(i);
            if (map.get(i) == 1)
                ans.get(1).add(i);
        }

        return ans;
    }
}