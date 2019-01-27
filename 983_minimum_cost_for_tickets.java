class Solution {
    // Time Complexity: O(365)
    // Space Complexity: O(365)
    public int mincostTickets(int[] days, int[] costs) {
        Integer[] memo = new Integer[366];
        Set<Integer> dayset = new HashSet<>();
        for (int d: days) dayset.add(d);

        return dp(1, memo, dayset, costs);
    }

    public int dp(int day, Integer[] memo, Set<Integer> dayset, int[] costs) {
        if (day > 365) {
            return 0;
        }

        if (memo[day] != null) {
            return memo[day];
        }

        int ans;
        if (dayset.contains(day)) {
            ans = Math.min(dp(day + 1, memo, dayset, costs) + costs[0], dp(day + 7, memo, dayset, costs) + costs[1]);
            ans = Math.min(ans, dp(day + 30, memo, dayset, costs) + costs[2]);
        } else {
            ans = dp(day + 1, memo, dayset, costs);
        }

        memo[day] = ans;
        return ans;
    }
}
