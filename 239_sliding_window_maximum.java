class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int length = nums.length - k + 1;
        int result[] = new int[length];
        for (int i = 0; i < length; i++){
            int subArr[] = Arrays.copyOfRange(nums, i, i + k);
            result[i] = findMax(subArr);
        }
        return result;
    }

    private int findMax(int[] list){
        int max = list[0];
        int len = list.length;
        for (int i = 0; i < len; i++){
            if (list[i] > max){
                max = list[i];
            }
        }
        return max;
    }
}
