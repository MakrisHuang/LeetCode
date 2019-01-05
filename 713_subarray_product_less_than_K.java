class Solution {
    /*
        使用 sliding window 紀錄當下的 product: 一直向右擴展，若大於 sum 時，除 nums[left] 並 left--
        為何 ans += right - left + 1 ? 當我們紀錄 (i, j) 的 product 小於 k 時
        (i, j), (i + 1, j) ... (j, j) 的每個 subarray 其乘積也都小於 k，故加入
        ex. nums = [10, 5, 2, 6], k = 100
            left: 0, right: 0 -> [10]
            left: 0, right: 1 -> [10, 5], [5]
            left: 1, right: 2 -> [5, 2], [2]
            left: 1, right: 3 -> [5, 2, 6], [2, 6], [6]
    */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0, prod = 1;
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            System.out.println("left: " + left + ", right: " + right);
            ans += right - left + 1;
        }
        return ans;
    }
}
