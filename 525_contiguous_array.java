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
            if (sumToIndex.containsKey(prefix[i])) {
                max = Math.max(max, i - sumToIndex.get(prefix[i]));           
            } else {
                sumToIndex.put(prefix[i], i);
            }
        }
        return max;
    }
}