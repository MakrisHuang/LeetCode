class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.get(nums[i]) == null)
                map.put(nums[i], 1);
            else
                map.put(nums[i], 0);
        }

        int value = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) {
                value = entry.getKey();
            }
        }
        return value;
    }
}
