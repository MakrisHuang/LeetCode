class Solution {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack();
        stack.push(0); // The score of the current frame

        for (char c: S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                // When we see a closing bracket, we add twice the score of the previous deeper part

                // except when counting (), which has a score of 1.
                // and we can use max(2 * v, 1) for comparison
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
