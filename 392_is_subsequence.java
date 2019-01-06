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

    /*
        Follow-up: Using binary search with hashmap
        HashMap: check a character is in string s
        Binary Search: find the index in the given character
        ex. s = "aec", t = "ahbggce"
            for t, we have {"a": [0], "b": [2], "c": [5], "e": [6], "g": [3, 4], "h": [1]}, and we have the logs:
                c: a
                List: 0
                mid: 0, index: -1
                prev: 0
                --------------------
                c: e
                List: 6
                mid: 6, index: 1
                prev: 6
                --------------------
                c: c
                List: 5
                mid: 5, index: 7
                prev: -1
            Since second character `e` in s is at the end of t, we cannot find `c` after index of `e` in string t
     */
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;

        Map<Character, List<Integer>> map = new HashMap<>(); //<character, index>

        // push the indexes into map given the character in t
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
            System.out.println("c: " + c);
            if (map.get(c) == null)  {
                return false;
            } else {
                List<Integer> list = map.get(c);
                System.out.print("List: ");
                for (int val: list) {
                    System.out.print(val + " ");
                }
                System.out.println();
                prev = binarySearch(prev, list, 0, list.size() - 1);
                System.out.println("prev: " + prev);
                System.out.println("--------------------");
                if (prev == -1) {
                    return false;
                }
                prev++;
            }
        }
        return true;
    }
    /*
        keep searching index. If mid < index, search at right (increase). Once start == list.size() => not found
    */
    private int binarySearch(int index, List<Integer> list, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println("mid: " + list.get(mid) + ", index: " + index);
            if (list.get(mid) < index) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start == list.size() ? -1 : list.get(start);
    }
}
