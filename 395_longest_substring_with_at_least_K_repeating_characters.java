class Solution {
    // Since we know there are at most 26 unique alphabet in a string
    // so we can specify number of unique alphabet from 1 to 26
    // and apply sliding window to get maximum length of string
    // Time Complexity: O(26 * len(str) ^ 2)
    // Space Complexity: O(1)
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0){
           return 0;
        }
        int max = 0;
        for (int numTargetDistinct = 1; numTargetDistinct <= 26; numTargetDistinct++){
            int len = longestDistinct(s, k, numTargetDistinct);
            max = Math.max(max, len);
        }
        return max;
    }
    private int longestDistinct(String s, int k, int numTargetDistinct){
        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int uniqueNum = 0;
        int noLessThanKNum = 0;
        int max = 0;
        while (end < s.length()){
            char cEnd = s.charAt(end);
            map.put(cEnd, map.getOrDefault(cEnd, 0) + 1);
            if (map.get(cEnd) == 1){
                uniqueNum++;
            }
            if (map.get(cEnd) == k){
                noLessThanKNum++;
            }
            end++;
            while (uniqueNum > numTargetDistinct){
                char cStart = s.charAt(start);
                if (map.get(cStart) == k){
                    noLessThanKNum--;
                }
                if (map.get(cStart) == 1){
                    uniqueNum--;
                }
                map.put(cStart, map.get(cStart) - 1);
                start++;
            }
            if (uniqueNum == noLessThanKNum){
                max = Math.max(max, end - start);
            }
        }
        return max;
    }
}
