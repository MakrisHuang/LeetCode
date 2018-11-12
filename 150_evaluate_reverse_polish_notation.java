class Solution {
    private static final Set<String> OPERATORS = 
        new HashSet<>(Arrays.asList("+", "-", "*", "/"));
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token: tokens){
            if (OPERATORS.contains(token)){
                int y = stack.pop();
                int x = stack.pop();
                int result = eval(x, y, token);
                stack.push(result);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    
    private int eval (int x, int y, String op){
        switch (op){
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            default : return x / y;
        }
    }
}