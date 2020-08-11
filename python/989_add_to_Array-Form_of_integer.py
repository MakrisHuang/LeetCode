class Solution:
    def addToArrayForm(self, A: List[int], K: int) -> List[int]:
        N = len(A)
        curr = N - 1
        # use K as the guard in for loop
        carry = 0
        while K > 0:
            sum = carry + (K % 10)
            if curr >= 0:
                sum += A[curr]
            carry = int(sum / 10)
            digit = sum % 10

            if curr < 0:
                # append the digits from K to array A
                A.insert(0, digit)
            else:
                A[curr] = digit
                curr -= 1
            K = int(K / 10)
        # keep adding numbers as we still have digits in A (although K is already 0)
        while curr >= 0 and carry > 0:
            sum = carry + A[curr]
            carry = int(sum / 10)
            A[curr] = sum % 10
            curr -= 1
        if curr < 0 and carry > 0:
            A.insert(0, carry)
        return A
