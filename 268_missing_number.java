class Solution {
    public int missingNumber(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int sum = 0;
        for (int num: nums) {
            if (num > largest) largest = num;
            sum += num;
        }
        int origTotal = (1 + nums.length) * nums.length / 2;
        return origTotal - sum;
    }
}
