class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        for (int idx1 = 0; idx1 < len1; idx1++) {
            int curr = nums1[idx1];
            int min = Integer.MAX_VALUE;
            for (int idxOfNums2 = len2 - 1; idxOfNums2 >= 0; idxOfNums2--) {
                if (nums2[idxOfNums2] == curr) {
                    if (min == Integer.MAX_VALUE) {
                        res[idx1] = -1;
                    } else {
                        res[idx1] = min;
                    }
                    break;
                }
                if (nums2[idxOfNums2] < Integer.MAX_VALUE && nums2[idxOfNums2] > curr) {
                    min = nums2[idxOfNums2];
                }
            }
        }

        return res;
    }
}
