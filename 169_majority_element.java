class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxTimes = Integer.MIN_VALUE, ele = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxTimes) {
                ele = entry.getKey();
                maxTimes = entry.getValue();
            }
                
        }
        return ele;
    }
}