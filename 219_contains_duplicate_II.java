class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();  // key: num, value: index of given number
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            List<Integer> indexes = null;
            if (map.containsKey(num)) {
                indexes = map.get(num);
            } else {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            map.put(num, indexes);
        }

        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            List<Integer> indexes = entry.getValue();
            if (indexes.size() > 1) {
                for (int i = 1; i < indexes.size(); i++) {
                    if (indexes.get(i) - indexes.get(i - 1) <= k) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
