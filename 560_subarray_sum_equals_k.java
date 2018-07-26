class Solution {
    public int subarraySum(int[] nums, int k) {
        // if (nums == null || nums.length == 0) return 0;
        // int count = 0, len = nums.length;
        // for (int i = 0; i < len; i++) {
        //     int sum = 0, idx = i;
        //     while (idx < len) {
        //         sum += nums[idx++];
        //         if (sum == k) {
        //             count++;
        //         }
        //     }
        // }
        // return count;
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];     // sum: SUMS(0, i - 1)
            if (preSum.containsKey(sum - k)) {  // sum - k: SUMS(0, j) - SUMS(0, i - 1) -> get SUMS(i, j)
                result += preSum.get(sum - k);
            }
            preSum.put(sum, preSum.getOrDefault(sum, 0) + 1);
        }
        return result;
    }
}
