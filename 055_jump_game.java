class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        for (int reach = 0; i < nums.length && i <= reach; ++i){
            // System.out.println("i = " + i + ", nums[i] = " + nums[i]);
            reach = Math.max(i + nums[i], reach);
            // System.out.println("after max, reach = " + reach);
        }
        return i == nums.length;
    }
}