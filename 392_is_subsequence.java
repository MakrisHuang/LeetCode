class Solution {
    // time complexity: O(sLen * tLen), Space Complexity: O(1)
    public boolean isSubsequence(String s, String t) {
        int sIdx = 0, tIdx = 0, sLen = s.length(), tLen = t.length();
        while (sIdx < sLen && tIdx < tLen) {
            char sChar = s.charAt(sIdx);
            while (tIdx < tLen) {
                if (t.charAt(tIdx) != sChar) {
                    tIdx++;
                } else {
                    sIdx++;
                    tIdx++;
                    break;
                }
            }
        }
        if (tIdx == tLen && sIdx != sLen) {
            return false;
        }
        return true;
    }
    
    // follow up: using binary search 
    // https://leetcode.com/problems/is-subsequence/discuss/87268/Java-code-for-the-follow-up-question
    
    /**
     * Follow-up
     * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t. 
     * This is inefficient. 
     * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t. 
     * Sounds like a HashMap, which is super suitable for search for existing stuff. 
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;

        Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

        //preprocess t
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i);
        }

        int prev = -1;  //index of previous character
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.get(c) == null)  {
                return false;
            } else {
                List<Integer> list = map.get(c);
                prev = binarySearch(prev, list, 0, list.size() - 1);
                if (prev == -1) {
                    return false;
                }
                prev++;
            }
        }
        return true;    
    }

    private int binarySearch(int index, List<Integer> list, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (list.get(mid) < index) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start == list.size() ? -1 : list.get(start);
    }
}