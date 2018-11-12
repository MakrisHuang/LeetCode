class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++){
            if (isLeftParenthesis(s.charAt(i))) {
                stack.push(s.charAt(i));
            }else{
                Character candidate = null;
                try{
                    candidate = stack.pop();
                } catch (Exception e){
                    return false;
                }
                if (isParenthesesMatched(candidate, s.charAt(i))) continue;
                else return false;
            }
        }
        if (! stack.empty()) return false;
        return true;
    }

    private boolean isLeftParenthesis(char c){
        return (c == '{' || c == '[' || c == '(') ? true : false;
    }

    private boolean isParenthesesMatched(char candidate, char matcher){
        if ((candidate == '{' && matcher == '}') ||
            (candidate == '[' && matcher == ']') ||
            (candidate == '(' && matcher == ')')) {
            return true;
        }
        return false;
    }
}
