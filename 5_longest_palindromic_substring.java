class Solution {
    public String longestPalindrome(String s) {
        // iterate each character c
        // for each c, find another c in the latter
        // then compare each character in the beginning and in the end
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++){
            for (int j = i + 1; j < s.length(); j++){
                if (s.charAt(i) == s.charAt(j)){
                    // start to check the substring as palindrome
                    String candidate = s.substring(i, j + 1);
                    if (candidate.length() > longestPalindrome.length()){
                        boolean isPalindrome = checkPalindrome(candidate);
                        if (isPalindrome){
                            longestPalindrome = candidate;
                        }
                    }
                    if (longestPalindrome.length() == s.length()){
                        return s;
                    }
                }
            }
        }
        if (longestPalindrome.length() == 0){
            longestPalindrome = s.substring(0, 1);
        }
        return longestPalindrome;
    }

    private boolean checkPalindrome(String candidate){
        for (int i = 0, j = candidate.length() - 1; i <= j; i++, j--){
            // if any pair of begin and end is not identical, then quit
            if (candidate.charAt(i) != candidate.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
