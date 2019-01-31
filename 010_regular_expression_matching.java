class Solution {
    // use backtrace to partially consume text
    public boolean isMatch(String text, String pattern) {
        if (pattern.isEmpty()) return text.isEmpty();

        // check first character is match
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        // then we deal with '*'
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            // text = "aaa", pattern = "a*a"
            // check isMatch("aaa", "a") || (first_match && isMatch("aa", "a*a")
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            // match rest of them
            // ex. text = "ab", pattern = ".b"
            // then call isMatch("b", "b")
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
//         int sIdx = 0, pIdx = 0;
//         int sLen = s.length(), pLen = p.length();
//         while (sIdx < sLen || pIdx < pLen) {
//             char sCh = s.charAt(sIdx);

//             char pCh = p.charAt(pIdx);
//             Character ast = null;
//             if (pIdx + 1 < pLen && p.charAt(pIdx + 1) == '*') {
//                 ast = '*';
//             }

//             // start matching
//             if (ast == null) {
//                 if (sCh == pCh || pCh == '.') {
//                     sIdx++;
//                     pIdx++;
//                 }
//             } else {    // '*' exists
//                 if (sCh != pCh && pCh != '.') {
//                     // pIdx move forward to next pair
//                     pIdx += 2;
//                 } else {
//                     sIdx++;
//                 }
//             }

//             // move .* or a* forward
//             if (sIdx == sLen && ast != null) {
//                 pIdx += 2;
//             }

//             // complete match
//             if (sIdx == sLen) {
//                 if (pIdx == pLen || (pIdx == pLen - 2 && ast != null)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
    }
}
