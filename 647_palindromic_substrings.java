class Solution {
    public int countSubstrings(String s) {
        int N = s.length(), counter = 0;
        for (int center = 0; center < 2 * N - 1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && s.charAt(left) == s.charAt(right)) {
                counter++;
                left--;
                right++;
            }
        }
        return counter;

        /*
            Brute-force method: get all possible substring
        */

//         if (s == null || s.length() == 0) return 0;
//         List<String> result = new ArrayList<>();
//         substr(result, s);

//         int count = 0;
//         for (String str: result) {
//             if (isPalindrome(str)) count++;
//         }

//         return count;
    }

    private void substr(List<String> result, String s) {
        for (int len = 1; len <= s.length(); len++) {
            for (int start = 0; start + len <= s.length(); start++) {
                result.add(s.substring(start, start + len));
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    private void print(List<String> result) {
        for (String s: result)
            System.out.println(s);
    }
}
