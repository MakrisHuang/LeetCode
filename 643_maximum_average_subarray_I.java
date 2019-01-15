class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        // get first continuous subarray
        for (int i = 0; i < k; i++) {
            sum += (double) nums[i];
        }
        double min = sum;

        // comparing with different length
        int left = 0;
        for (int right = k; right < nums.length; right++) {
            sum += nums[right];
            sum -= nums[left++];
            if (sum > min) {
                min = sum;
            }
        }
        return min / k;
    }
}
