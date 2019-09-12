class Solution:
    # Time Complexity: O(A + B)
    def strWithout3a3b(self, A: int, B: int) -> str:
        ans = ""
        while A or B:
            if len(ans) >= 2 and ans[-1] == ans[-2]:
                # compare last two elements as greedy selection function
                write_a = (ans[-1] == 'b')
            else:
                # always append with larger number
                write_a = (A >= B)

            if write_a:
                A -= 1
                ans += 'a'
            else:
                B -= 1
                ans += 'b'
        return ans
