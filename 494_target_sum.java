class Solution {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }

    // public int findTargetSumWays(int[] nums, int S) {
    //     List<Integer> result = new ArrayList<>();
    //     backtrack(result, new ArrayList<>(), nums, S);
    //     return result.size();
    // }

//     private void backtrack(List<Integer> result, List<Integer> temp, int[] nums, int S) {
//         if (temp != null && temp.size() == nums.length) {
//             print(temp);
//             int sum = 0;
//             for (Integer n: temp) sum += n;
//             System.out.println("sum: " + sum);
//             if (sum == S) result.add(sum);
//             return;
//         }
//         for (int i = temp.size(); i < nums.length; i++) {
//             int posNum = nums[i];
//             temp.add(posNum);
//             backtrack(result, temp, nums, S);
//             temp.remove(temp.size() - 1);

//             int negNum = -nums[i];
//             temp.add(negNum);
//             backtrack(result, temp, nums, S);
//             temp.remove(temp.size() - 1);
//         }
//     }

//     private void print(List<Integer> list) {
//         for (int i = 0; i < list.size(); i++) {
//             System.out.print(list.get(i) + " ");
//         }
//         System.out.println();
//     }
}
