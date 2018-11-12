class Solution {
    public int longestValidParentheses(String s) {
        int res = 0, start = 0;
        Stack<Integer> m = new Stack<Integer>();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') m.push(i);
            else if (s.charAt(i) == ')') {
                if (m.empty()) start = i + 1;
                else {
                    m.pop();
                    res = m.empty() ? Math.max(res, i - start + 1) : Math.max(res, i - m.peek());
                }
            }
        }
        return res;
    }
}