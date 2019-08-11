class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        for c in s:
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            else:
                if len(stack) <= 0:
                    return False
                else:
                    target = stack.pop()
                    if not self.checkMatch(target, c):
                        return False
        return True if len(stack) == 0 else False


    def checkMatch(self, target: str, cand: str):
        if target == "(" and cand == ")":
            return True
        elif target == "{" and cand == "}":
            return True
        elif target == "[" and cand == "]":
            return True
        return False
