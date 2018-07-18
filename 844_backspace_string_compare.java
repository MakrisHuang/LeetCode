class Solution {
    public boolean backspaceCompare(String S, String T) {
        for (int i = S.length() - 1, j = T.length() - 1;; i--, j--) {
            for (int b = 0; i >= 0 && (b > 0 || S.charAt(i) == '#'); --i) b += S.charAt(i) == '#' ? 1 : -1;
            for (int b = 0; j >= 0 && (b > 0 || T.charAt(j) == '#'); --j) b += T.charAt(j) == '#' ? 1 : -1;
            if (i < 0 || j < 0 || S.charAt(i) != T.charAt(j)) return i == -1 && j == -1;
        }

        // Stack<Character> st1 = new Stack<>();
        // Stack<Character> st2 = new Stack<>();
        // for (int i = 0; i < str1.length(); i++) {
        //     char c = str1.charAt(i);
        //     if (c == '#'){
        //         if (! st1.empty()) st1.pop();
        //     } else {
        //         st1.push(c);
        //     }
        // }
        // for (int j = 0; j < str2.length(); j++) {
        //     char c = str2.charAt(j);
        //     if (c == '#'){
        //         if (! st2.empty()) st2.pop();
        //     } else {
        //         st2.push(c);
        //     }
        // }
        // // compare both
        // while (!st1.empty() || !st2.empty()) {
        //     char c1 = '0', c2 = '0';
        //     if (!st1.empty()) c1 = st1.pop();
        //     if (!st2.empty()) c2 = st2.pop();
        //     if (c1 != c2) return false;
        // }
        // return true;
    }
}
