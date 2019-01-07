class Solution {
    // How do we know string s2 contains a permutation of s1? We just need to create a sliding window with length of s1, move from beginning to the end of s2. When a character moves in from right of the window, we subtract 1 to that character count from the map. When a character moves out from left of the window, we add 1 to that character count. So once we see all zeros in the map, meaning equal numbers of every characters between s1 and the substring in the sliding window, we know the answer is true.
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;

        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        print(count);
        if (allZero(count)) return true;

        for (int i = len1; i < len2; i++) {
            System.out.println("s2.charAt(" + i + ")" + s2.charAt(i));
            count[s2.charAt(i) - 'a']--;
            System.out.println("s2.charAt(" + (i - len1) + ")" + s2.charAt(i - len1));
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count)) return true;
        }

        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }

    private void print(int[] count) {
        for (int i = 0; i < 26; i++) {
            System.out.println(i + ": " + count[i]);
        }
        System.out.println();
    }

    // public boolean checkInclusion(String s1, String s2) {
    //     final int size1 = s1.length();
    //     final int size2 = s2.length();
    //     if (size1 > size2) {
    //         return false;
    //     }
    //     HashMap<Character, Integer> charFre = new HashMap<>();
    //     for (char c : s1.toCharArray()) {
    //         charFre.put(c, charFre.getOrDefault(c, 0) + 1);
    //     }
    //     int start = 0;
    //     int end = size1 - 1;
    //     HashMap<Character, Integer> curFre = new HashMap<>();
    //     for (int i = 0; i <= end; i++) {
    //         curFre.put(s2.charAt(i), curFre.getOrDefault(s2.charAt(i), 0) + 1);
    //     }
    //     while (end < size2) {
    //         end++;
    //         if (curFre.equals(charFre)) {
    //             return true;
    //         }
    //         if (end < size2) {
    //             curFre.put(s2.charAt(end), curFre.getOrDefault(s2.charAt(end), 0) + 1);
    //             curFre.put(s2.charAt(start), curFre.get(s2.charAt(start)) - 1);
    //         }
    //         if (curFre.get(s2.charAt(start)) <= 0) {
    //             curFre.remove(s2.charAt(start));
    //         }
    //         start++;
    //     }
    //     return false;
    // }
}
