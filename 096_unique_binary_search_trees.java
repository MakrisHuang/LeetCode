class Solution {
    // apply dynamic programming: select i as the root, then combine left and right subtree
    // F(i,n)=G(i−1)⋅G(n−i) where i is the selected root
    // and we want G(n) = Sigma(G(i - 1) * G(n - i)) where i goes from 1 to n

    // Time complexity: O(n ^ 2)
    // Space complexity: O(n)
    public int numTrees(int n) {
        int [] dp = new int[n+1];
        dp[0]= 1;
        dp[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                dp[level] += dp[level-root]*dp[root-1];
        return dp[n];
    }
}
