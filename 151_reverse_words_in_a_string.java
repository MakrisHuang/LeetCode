public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        if (s.length() == 0) return s;

        // reverse the entire sentence to reverse the order of words in the sentence
        s = reverse(s);

        List<String> list = new ArrayList<>();
        for (int begin = 0, end = 0; begin < s.length(); ) {
            if (s.charAt(begin) == ' ') {
                begin++; end++;
            } else if (end == s.length() || s.charAt(end) == ' ') {
                String str = s.substring(begin, end);
                list.add(reverse(str));
                begin = ++end;
            } else {
                end++;
            }
        }

        // concat reversed words in the list
        StringBuilder sb = new StringBuilder();
        int len = list.size();
        for(int i = 0; i < len; i++) {
            if (i != len - 1) sb.append(list.get(i) + " ");
            else sb.append(list.get(i));
        }

        return sb.toString();
    }

    private String reverse(String word) {
        if (word == null) return "";
        StringBuilder sb = new StringBuilder(word);
        int begin = 0;
        int end = word.length() - 1;
        while (begin < end) {
            Character temp = word.charAt(begin);
            sb.setCharAt(begin, word.charAt(end));
            sb.setCharAt(end, temp);
            begin++;
            end--;
        }
        return sb.toString();
    }
}
