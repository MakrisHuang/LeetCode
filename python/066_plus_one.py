class Solution:
    def plusOne2(self, digits: List[int]) -> List[int]:
        carry = 0
        digits[len(digits) - 1] += 1
        for i in range(len(digits) - 1, -1, -1):
            digits[i] += carry
            carry = 0
            if digits[i] > 9:
                carry = int(digits[i] / 10)
                digits[i] %= 10
        if carry > 0:
            digits = [carry] + digits
        return digits

    # other solution
    def plusOne(self, digits: List[int]) -> List[int]:
        sum = 0
        for i in digits:
            sum = sum * 10 + i
        return [int(x) for x in str(sum + 1)]


