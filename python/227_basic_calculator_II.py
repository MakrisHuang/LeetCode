class Solution:
    def calculate(self, s: str) -> int:
        num, stack, preOp = 0, [], "+"
        for i in range(len(s)):
            if s[i].isdigit():
                num = num * 10 + int(s[i])
            if s[i] in "+-*/" or i == len(s) - 1:
                if preOp == "+":
                    stack.append(num)
                elif preOp == "-":
                    stack.append(-num)
                elif preOp == "*":
                    stack.append(stack.pop() * num)
                else:
                    stack.append(int(stack.pop() / num))
                num = 0
                preOp = s[i]
        return sum(stack)
