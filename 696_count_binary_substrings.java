class Solution {
    // Time Complexity: O(N), Space Complexity: O(N)
    public int countBinarySubstrings(String s) {
        int[] groups = new int[s.length()];
        int t = 0;
        groups[0] = 1;  // assume first element stores 1
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i-1) != s.charAt(i)) {
                // while having different characters (either 0 or 1)
                // move to another section and set # of eles as 1
                groups[++t] = 1;
            } else {
                groups[t]++;
            }
        }

        int ans = 0;
        for (int i = 1; i <= t; i++) {
            // ans will exist between two group
            ans += Math.min(groups[i-1], groups[i]);
        }
        return ans;
    }

    // Time Complexity: O(N^2), Space Complexity: O(1)
    // public int countBinarySubstrings(String s) {
    //     int count = 0;
    //     for (int i = 0; i < s.length(); i++) {
    //         // keep looking characters in first group of 1 or 0
    //         int numCharFirstGroup = 0;
    //         int firstGroupIdx = i;
    //         while (firstGroupIdx < s.length() && s.charAt(i) == s.charAt(firstGroupIdx)) {
    //             firstGroupIdx++;
    //             numCharFirstGroup++;
    //         }
    //         // check character in next group is valid (ex. 0 -> 1, 1 -> 0)
    //         if (firstGroupIdx >= s.length()) {
    //             continue;
    //         } else {
    //             // keep looking characters in second group
    //             int numCharSecondGroup = 0;
    //             int secondGroupStart = firstGroupIdx;
    //             int secondGroupIdx = secondGroupStart;
    //             while (secondGroupIdx < s.length() && s.charAt(secondGroupStart) == s.charAt(secondGroupIdx)) {
    //                 secondGroupIdx++;
    //                 numCharSecondGroup++;
    //                 if (numCharFirstGroup == numCharSecondGroup) {
    //                     count++;
    //                     break;
    //                 }
    //             }
    //         }
    //     }
    //     return count;
    // }
}
