class Solution {
    /*
    * use dynamic programming that f(n) = f(n-1) + f(n-2)
    */
    public int climbStairs(int n) {
        int prev = 1, curr = 1;
        for (int i = 2; i <= n; i++){
            int temp = curr;
            curr += prev;
            prev = temp;
        }
        return curr;
    }
}
