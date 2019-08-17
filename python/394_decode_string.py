class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        idx = 0
        res = ""
        while idx < len(s):
            if s[idx].isnumeric():
                curr_idx = idx + 1
                while curr_idx < len(s) and s[curr_idx].isnumeric():
                    curr_idx += 1
                stack.append(int(s[idx:curr_idx]))
                idx = curr_idx
            elif s[idx] == "[":
                idx += 1
            elif s[idx].isalpha():
                curr_idx = idx + 1
                while curr_idx < len(s) and s[curr_idx].isalpha():
                    curr_idx += 1
                stack.append(s[idx:curr_idx])
                idx = curr_idx
            elif s[idx] == "]":
                temp = ""
                while stack and str(stack[-1]).isalpha():
                    temp = stack.pop() + temp
                if stack:
                    num = stack.pop()
                    temp = temp * num
                    stack.append(temp)
                idx += 1
        return "".join(stack)
