class Solution:
    """
    if the sequence is CPPCPPPPCP, we can divide them into [CPP][CPPPP][CP]
    say the groups have lengths of g1, g2..., and we will have g1 * g2...*gn 'A'

    Given x characters, we split it into a factorization where p * q = x
    That is, at first we have p characters, and then make q pastes
    To get p characters, it requires 1 copy and (p - 1) pastes -> (1 + p - 1) = p
    To get p * q characters, we make 1 copy and (q - 1) pastes -> (1 + q - 1) = q
    Therefore, we have p * q = x

    Time Complexity: O(N ^ 1/2)
    Space Complexity: O(1)
    """
    def minSteps(self, n):
        ans = 0
        d = 2
        while n > 1:
            while n % d == 0:
                ans += d
                n /= d
            d += 1
        return ans
