class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int maxLen = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // add the trivial case of 0-length starting subarray to the map
        // if i == 0 and we found it, then (i - map.get(0)) = (0 - (-1)) = 1 => length = 1
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
            if (! map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLen;
    }
}
