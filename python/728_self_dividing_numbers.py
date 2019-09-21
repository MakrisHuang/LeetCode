class Solution:
    def selfDividingNumbers(self, left: int, right: int) -> List[int]:
        res = []
        while left <= right:
            if 0 < left < 10:
                res.append(left)
                left += 1
                continue

            if left % 10 == 0:
                left += 1
                continue

            isSelfDividing = True
            for c in str(left):
                if int(c) == 0 or left % int(c) != 0:
                    isSelfDividing = False
                    break
            if isSelfDividing:
                res.append(left)

            left += 1
        return res
