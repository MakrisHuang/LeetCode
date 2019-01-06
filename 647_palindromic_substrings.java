class Solution {
    /* Find palindrome from each center
    The reason is the center of a palindrome can be in between two letters.
    Such palindromes have even number of letters (such as “abba”)
    and its center are between the two ‘b’s.
    Let say the length of a string is N, and there are N - 1 spaces between characters
    so we will have N + N - 1 = 2N - 1 possible centers to choose from

    To iterate over each of the 2N-1 centers, we will move the left pointer every 2 times, and the right pointer every 2 times starting with the second (index 1). Hence, left = center / 2, right = center / 2 + center % 2.
    */
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
