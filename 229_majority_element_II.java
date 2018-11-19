class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();

        int candA = nums[0], candB = nums[0];
        int countA = 0, countB = 0;
        for (int num: nums) {
            if (candA == num) {
                countA++;
                continue;
            }

            if (candB == num) {
                countB++;
                continue;
            }

            if (countA == 0) {
                candA = num;
                countA++;
                continue;
            }

            if (countB == 0) {
                candB = num;
                countB++;
                continue;
            }

            countA--;
            countB--;
        }

        countA = 0;
        countB = 0;
        List<Integer> res = new ArrayList<>();

        for (int num : nums) {
            if (num == candA) {
                countA++;
            }
            else if (num == candB) {
                countB++;
            }
        }
        int times = nums.length / 3;
        if (countA > times) {
            res.add(candA);
        }
        if (countB > times) {
            res.add(candB);
        }
        return res;
    }
}
