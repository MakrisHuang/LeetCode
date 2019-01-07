class Solution {
    public int findMaxLength(int[] nums) {
        if (nums.length < 2) return 0;

        // calculate prefix sum
        int[] prefix = Arrays.copyOf(nums, nums.length);
        prefix[0] = (prefix[0] == 0 ? -1 : 1);

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1]+ (prefix[i] == 0 ? -1 : 1);
        }

        int max = 0;
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);

        for (int i = 0; i < prefix.length; i++) {
            // 若 prefix[i] 在 map 有出現，代表從 map.get(prefix[i]) 的 index
            // 到現在的 i 其中的差值是 0，也代表中間的 0, 1 是成雙成對的
            // 因此 range 就是 [map.get(prefix[i]), i)
            if (sumToIndex.containsKey(prefix[i])) {
                max = Math.max(max, i - sumToIndex.get(prefix[i]));
            } else {
                sumToIndex.put(prefix[i], i);
            }
        }
        return max;
    }
}
