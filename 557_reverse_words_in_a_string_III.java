class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            sb.append(reverse(words[i]));
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public String reverse(String word) {
        String res = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            res += word.charAt(i);
        }
        return res;
    }
}
