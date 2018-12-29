class Solution {
    public boolean backspaceCompare(String str1, String str2) {
        // Apply two pointer version
        // Time Complexity: O(len(str1) + len(str2))
        // Space Complexity: O(1)
        int i = str1.length() - 1, j = str2.length() - 1;
        int skip1 = 0, skip2 = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (str1.charAt(i) == '#') {
                    skip1++; i--;
                } else if (skip1 > 0) {
                    skip1--; i--;
                } else {
                    break;
                }
            }

            while (j >= 0) {
                if (str2.charAt(j) == '#') {
                    skip2++; j--;
                } else if (skip2 > 0) {
                    skip2--; j--;
                } else {
                    break;
                }
            }

            if (i >= 0 && j >= 0 && str1.charAt(i) != str2.charAt(j)) {
                return false;
            }

            if ((i >= 0) != (j >= 0)) {
                return false;
            }
            i--; j--;
        }
        return true;

        // Stack version
        // Time Complexity: O(len(str1) + len(str2))
        // Space Complexity: O(len(str1) + len(str2))
        //
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
