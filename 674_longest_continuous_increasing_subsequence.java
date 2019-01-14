class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;

        int ans = 0;
        int orig = 0;
        while (orig + 1 < nums.length) {
            int curr = orig;
            int next = curr + 1;
            while (next < nums.length && nums[next] > nums[curr]) {
                curr = next;
                next++;
            }
            ans = Math.max(ans, next - orig);
            orig = next;
        }
        return ans;
    }
}
