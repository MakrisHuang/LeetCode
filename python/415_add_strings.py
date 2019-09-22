class Solution:
    def addStrings(self, num1: str, num2: str) -> str:
        num1_idx = len(num1) - 1
        num2_idx = len(num2) - 1

        carry = 0
        res = []
        while num1_idx >= 0 or num2_idx >= 0:
            n1 = 0
            if num1_idx >= 0:
                n1 = (ord(num1[num1_idx]) - ord('0'))
                num1_idx -= 1
            n2 = 0
            if num2_idx >= 0:
                n2 = (ord(num2[num2_idx]) - ord('0'))
                num2_idx -= 1

            accum = carry + n1 + n2
            carry = accum // 10
            accum = accum % 10
            res.insert(0, str(accum))

        if carry > 0:
            res.insert(0, str(carry))
        return "".join(res)

