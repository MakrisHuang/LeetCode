class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int[][] pairs = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            pairs[i][0] = i;
            pairs[i][1] = nums[i];
        }

        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        String[] result = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                result[pairs[i][0]] = "Gold Medal";
            } else if (i == 1) {
                result[pairs[i][0]] = "Silver Medal";
            } else if (i == 2) {
                result[pairs[i][0]] = "Bronze Medal";
            } else {
                result[pairs[i][0]] = i + 1 + "";
            }
        }
        return result;
    }
}
