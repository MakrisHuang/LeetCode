class Solution:
    def multiply(self, num1: str, num2: str) -> str:
        l1, l2 = len(num1), len(num2)
        res = [0 for _ in range(l1 + l2)]
        carry1 = carry2 = 0
        for i in range(l1 - 1, -1, -1):
            for j in range(l2 - 1, -1, -1):
                mul = carry1 + int(num1[i]) * int(num2[j])
                p1 = i + j
                p2 = i + j + 1
                accum = res[p2] + mul

                res[p1] += accum // 10
                res[p2] = accum % 10
        startWithoutZero = 0
        while startWithoutZero < len(res) and res[startWithoutZero] == 0:
            startWithoutZero += 1
        res = res[startWithoutZero:]
        s = "".join([str(c) for c in res])
        return s if s != "" else "0"
