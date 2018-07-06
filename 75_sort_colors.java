class Solution {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        // overwrite elements in the array
        int idx = 0;
        for (int color = 0; color <= 2; color++) {
            if (map.containsKey(color)) {
                for (int i = 0; i < map.get(color); i++) {
                    nums[i + idx] = color;
                }
                idx += map.get(color);
            }
        }
    }
}
