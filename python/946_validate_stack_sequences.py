class Solution:
    def validateStackSequences(self, pushed: List[int], popped: List[int]) -> bool:
        pop_i = 0
        stack = []
        for target in pushed:
            stack.append(target)
            while stack and stack[-1] == popped[pop_i]:
                stack.pop()
                pop_i += 1

        return pop_i == len(popped)
