class Solution {
    // Use two map to store and compare occurrence times
    // Time Complexity: O(len(s) * wordNum)
    // Space Complexity: O(wordNum)
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) {
            return res;
        }
        int wordLen = words[0].length();

        Map<String, Integer> allWordsMap = new HashMap<>();
        for (String word: words) {
            allWordsMap.put(word, allWordsMap.getOrDefault(word, 0) + 1);
        }

        // traverse all substring
        for (int i = 0; i < s.length() - wordNum * wordLen + 1; i++) {
            Map<String, Integer> currMap = new HashMap<>();
            int num = 0;

            // examine the substring is matched
            while (num < wordNum) {
                // move to next segment (word)
                String word = s.substring(i + num * wordLen, i + (num + 1) * wordLen);
                if (allWordsMap.containsKey(word)) {
                    currMap.put(word, currMap.getOrDefault(word, 0) + 1);

                    // compare occurrences times
                    if (currMap.get(word) > allWordsMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }

            // check number of words we found
            if (num == wordNum) {
                res.add(i);
            }
        }
        return res;
    }
}
