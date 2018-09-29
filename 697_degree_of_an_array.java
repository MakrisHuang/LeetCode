class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxNum = 0, maxCount = Integer.MIN_VALUE;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxNum = entry.getKey();
            }
        }
        List<Integer> cand = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == maxCount) cand.add(entry.getKey());
        }

        int minLength = Integer.MAX_VALUE;
        for (int candNum: cand) {
            int start = 0, end = nums.length - 1;
            while(nums[start] != candNum) start++;
            while(nums[end] != candNum) end--;
            int len = end - start + 1;
            if (len < minLength) minLength = len;
        }

        return minLength;
    }
}
