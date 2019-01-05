class Solution {
    // 利用餘數來得知中間的 range sum 是否為 k 的倍數
    // 從簡單的例子可以得知：13 / 6 = 2 ... 1
    // 則增加 6 的倍數後：(13 + 6*2) / 6 = 4 ... 1 => 6*2 即為 subarray sum 且為 k 的倍數
    // 因此，若在 i 找到跟之前相同的餘數 r，則代表 range (map.get(r), i) 的和是 k 的倍數
    // ex. [23, 2, 4, 6, 7], k = 6
    // map.put(5, 0) -> map.put(1, 1) -> map.get(5) = 0
    // (0 + 1, 2) => 為 6 倍數的 subarray
    public boolean checkSubarraySum(int[] nums, int k) {
        // Key: sum, Value: index
        Map<Integer, Integer> presumMap = new HashMap<>();
        presumMap.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (k != 0) {
                sum %= k;
            }
            if (presumMap.containsKey(sum)) {
                if (i - presumMap.get(sum) > 1) {
                    return true;
                }
            } else {
                presumMap.put(sum, i);
            }
        }
        return false;
    }
}
