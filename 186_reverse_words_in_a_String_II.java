class Solution {
    public void reverseWords(char[] str) {
        // 1. reverse all sentence
        reverse(str, 0, str.length - 1);

        // 2. reverse each word
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }

        // 3. reverse the last word
        reverse(str, start, str.length - 1);
    }

    public void reverse(char[] str, int start, int end) {
        while (start < end) {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
