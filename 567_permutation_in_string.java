class Solution {
    public boolean checkInclusion(String s1, String s2) {
        final int size1 = s1.length();
        final int size2 = s2.length();
        if (size1 > size2) {
            return false;
        }
        HashMap<Character, Integer> charFre = new HashMap<>();
        for (char c : s1.toCharArray()) {
            charFre.put(c, charFre.getOrDefault(c, 0) + 1);
        }
        int start = 0;
        int end = size1 - 1;
        HashMap<Character, Integer> curFre = new HashMap<>();
        for (int i = 0; i <= end; i++) {
            curFre.put(s2.charAt(i), curFre.getOrDefault(s2.charAt(i), 0) + 1);
        }
        while (end < size2) {
            end++;
            if (curFre.equals(charFre)) {
                return true;
            }
            if (end < size2) {
                curFre.put(s2.charAt(end), curFre.getOrDefault(s2.charAt(end), 0) + 1);
                curFre.put(s2.charAt(start), curFre.get(s2.charAt(start)) - 1);
            }
            if (curFre.get(s2.charAt(start)) <= 0) {
                curFre.remove(s2.charAt(start));
            }
            start++;
        }
        return false;
//         List<List<String>> result = new ArrayList<>();
//         permute(result, new ArrayList<>(), s1, new boolean[s1.length()]);

//         List<String> combined = new ArrayList<>();
//         for (List<String> list: result) {
//             StringBuilder sb = new StringBuilder();
//             list.forEach(sb::append);
//             combined.add(sb.toString());
//         }

//         for (String str: combined) {
//             if (s2.contains(str)) return true;
//         }
//         return false;
    }

    // private void permute(List<List<String>> result, List<String> tempList,
    //                      String s, boolean[] used) {
    //     if (tempList.size() == s.length()) {
    //         result.add(new ArrayList<>(tempList));
    //     } else {
    //         for (int i = 0; i < s.length(); i++) {
    //             if (used[i] || i > 0 && s.charAt(i) == s.charAt(i - 1) && !used[i - 1]) continue;
    //             used[i] = true;
    //             tempList.add(String.valueOf(s.charAt(i)));
    //             permute(result, tempList, s, used);
    //             used[i] = false;
    //             tempList.remove(tempList.size() - 1);
    //         }
    //     }
    // }
}
