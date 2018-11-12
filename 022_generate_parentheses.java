class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrace(result, "", 0, 0, n);
        return result;
    }

    private void backtrace(List<String> result, String curr, int open, int close, int max) {
        if (curr.length() == 2 * max) {
            result.add(curr);
            return;
        }

        if (open < max)
            backtrace(result, curr + "(", open + 1, close, max);
        if (close < open)
            backtrace(result, curr + ")", open, close + 1, max);
    }
}
