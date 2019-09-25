class Solution:
    def numTrees(self, n: int) -> int:
        """
        apply dp: select i as the root, then the left part is from 1 -> i - 1
        the right part would be (n - i)

        Given F(i, n) where i represent i nodes given total n nodes
        F(i, n) = G(i - 1) * G(n - i)
        and we want to G(n) = Sigma(G(i - 1) * G(n - i)) where i goes from 1 to n

        Since we need to get G(1), G(2)....
        we use a lower number represent inner calculation

        Time Complexity: O(n ^ 2)
        Space Complexity: O(n)
        """
        G = [0] * (n + 1)
        G[0] = 1
        G[1] = 1

        for i in range(2, n + 1):
            for j in range(1, i + 1):
                G[i] += G[j - 1] * G[i - j]
        return G[n]
