class Solution {
    // Using HashMap
    // Time Complexity: O(n ^ 3), Size of recursion tree can go up to n^2. The creation of list takes n time.
    // Space Complexity: O(n ^ 3). The depth of the recursion tree can go up to n ^ 2 and each activation record can contains a string list of size
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return word_Break(s, wordSet, 0);
    }
    HashMap<Integer, List<String>> map = new HashMap<>();

    public List<String> word_Break(String s, Set<String> wordDict, int start) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        LinkedList<String> res = new LinkedList<>();
        if (start == s.length()) {
            res.add("");
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end))) {
                List<String> list = word_Break(s, wordDict, end);
                for (String l : list) {
                    res.add(s.substring(start, end) + (l.equals("") ? "" : " ") + l);
                }
            }
        }
        map.put(start, res);
        return res;
    }



    // TLE
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return null;

        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordDict);

        List<List<String>> res = new ArrayList<>();
        backtrace(s, wordSet, 0, res, new ArrayList<>());

        List<String> ans = new ArrayList<>();
        res.forEach(seq -> ans.add(String.join(" ", seq)));
        return ans;
    }

    private void backtrace(String s, Set<String> wordSet, int start, List<List<String>> res, List<String> temp) {
        if (start == s.length()) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = start; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (wordSet.contains(sub)) {
                temp.add(sub);
                backtrace(s, wordSet, i, res, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
