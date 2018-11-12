// O(n) in runtime, O(n) for extra space
/*
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            if (map.get(nums[i]) == null)
                map.put(nums[i], 1);
            else
                map.put(nums[i], 0);
        }
        // System.out.println(map);
        int value = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() == 1) {
                value = entry.getKey();
            }
        }
        return value;
    }
}
*/

// Use XOR: a number with itself in XOR manipulation will be zero
class Solution {
    public int singleNumber(int[] nums){
        int num = 0;
        for (int x : nums){
            num = num ^ x;
        }
        return num;
    }
}