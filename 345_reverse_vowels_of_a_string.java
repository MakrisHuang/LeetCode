class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;

        List<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder(s);
        int start = 0, end = s.length() - 1;
        while(start < end) {
            char startChar = s.charAt(start);
            char endChar = s.charAt(end);
            if (vowels.contains(startChar) && vowels.contains(endChar)) {
                sb.setCharAt(start, endChar);
                sb.setCharAt(end, startChar);
                start++;
                end--;
            } else if (vowels.contains(startChar) && !vowels.contains(endChar)){
                end--;
            } else if (!vowels.contains(startChar) && vowels.contains(endChar)){
                start++;
            } else {
                start++;
                end--;
            }
        }
        return sb.toString();
    }
}
