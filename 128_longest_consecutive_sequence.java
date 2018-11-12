class Solution {
    // apply hashset to record each element exist 
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int longestConsecutive(int[] nums) {
        int ans = 0;
        if (nums == null || nums.length == 0) return ans;
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            set.add(num);
        }
        
        for (int i = 0; i < nums.length; i++) {
            // indicate it's the first element
            if (! set.contains(nums[i] - 1)) {
                int ele = nums[i];
                // keep finding other elements 
                // Time Complexity: O(1)
                while (set.contains(ele)) {
                    ele++;
                }
                
                ans = Math.max(ans, ele - nums[i]);
            }
        }
        return ans;
    }
}