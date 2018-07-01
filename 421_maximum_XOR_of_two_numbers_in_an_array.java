class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                int ones = num & mask;
                set.add(ones);    // 取前面有 1 的部分
            }
            int tmp = max | (1 << i);
            for(int prefix : set){
                int and = tmp ^ prefix;
                if(set.contains(and)) {
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }
}
