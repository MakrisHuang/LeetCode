class Solution {
    // This problem requires to maintain a window of size k of the previous values that can be queried for value ranges.
    // The best data structure to do that is Binary Search Tree.
    // As a result maintaining the tree of size k will result in time complexity O(N lg K).
    // In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries can be executed both of time complexity O(lg K)

    // Time Complexity: O(nlog(min(n,k)))
    // Space Complexity: O(min(n, k))
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            // Find successor of nums[i]
            Long s = set.ceiling((long)nums[i]);
            if (s != null && s <= nums[i] + t) return true;

            // find predsuccessor that smaller than nums[i]
            Long p = set.floor((long)nums[i]);
            if (p != null && nums[i] - t <= p ) return true;

            set.add((long)nums[i]);
            if (set.size() > k) {   // keep the sliding window size <= k
                                    // k = distance between (i, j)
                set.remove((long)nums[i - k]);
            }
        }
        return false;
    }

    // public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length && Math.abs(j - i) <= k; j++) {
    //             if (Math.abs((long)nums[i] - (long)nums[j]) <= t) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }
}
