class Solution {
    // Time Complexity: O(M * N) where M = average length of word, N = number of words
    // Space Complexity: O(M * N)
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);

        List<String> p = new ArrayList<>();
        p.add(beginWord);

        Queue<List<String>> pathsQueue = new LinkedList<>();
        pathsQueue.offer(p);

        List<List<String>> res = new ArrayList<>();

        int level = 1, minLevel = Integer.MAX_VALUE;
        Set<String> wordsSet = new HashSet<>();
        while (pathsQueue.size() != 0) {
            List<String> t = pathsQueue.poll();
            // if a path has length longer than level
            // then get rid of it (a.k.a. prune)
            if (t.size() > level) {
                // current length is larger than level
                // means some words already exist in the dict
                // ex. [cot, dot, cot]
                // then cot need to be removed
                for (String word: wordsSet) {
                    dict.remove(word);
                }
                wordsSet = new HashSet<>();
                level = t.size();
                if (level > minLevel) break;
            }
            String last = t.get(t.size() - 1);
            for (int i = 0; i < last.length(); i++) {
                char[] chars = last.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    chars[i] = c;
                    String newLast = new String(chars);
                    if (! dict.contains(newLast)) continue;
                    wordsSet.add(newLast);

                    // init a new path based on previous path
                    List<String> nextPath = new ArrayList<>(t);
                    nextPath.add(newLast);
                    if (newLast.equals(endWord)) {
                        res.add(nextPath);
                        minLevel = level;
                    } else {
                        pathsQueue.offer(nextPath);
                    }
                }
            }
        }
        return res;
    }
}
