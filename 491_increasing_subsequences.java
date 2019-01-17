class Solution {
    // Time Complexity: n ^ 2
    // Space Complexity: n ^ 2 + n ^ 2 + ... + n ^ 2 = n ^ 2
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        backtrace(res, new ArrayList<>(), nums, 0);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
    }

    public void backtrace(Set<List<Integer>> res, List<Integer> temp, int[] nums, int start) {
        if (temp.size() >= 2) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = start; i < nums.length; i++) {
            if (temp.size() == 0 || temp.get(temp.size() - 1) <= nums[i]) {
                temp.add(nums[i]);
                backtrace(res, temp, nums, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
