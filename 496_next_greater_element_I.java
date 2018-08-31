class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < nums2.length; i++) {
            while (! st.empty() && nums2[i] > st.peek()) {
                map.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }
        // pop remaining
        while (! st.empty()) {
            map.put(st.pop(), -1);
        }

        int len1 = nums1.length;
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
//         brute-force
//         int len1 = nums1.length;
//         int len2 = nums2.length;
//         int[] res = new int[len1];
//         for (int idx1 = 0; idx1 < len1; idx1++) {
//             int curr = nums1[idx1];
//             int min = Integer.MAX_VALUE;
//             for (int idxOfNums2 = len2 - 1; idxOfNums2 >= 0; idxOfNums2--) {
//                 if (nums2[idxOfNums2] == curr) {
//                     if (min == Integer.MAX_VALUE) {
//                         res[idx1] = -1;
//                     } else {
//                         res[idx1] = min;
//                     }
//                     break;
//                 }
//                 if (nums2[idxOfNums2] < Integer.MAX_VALUE && nums2[idxOfNums2] > curr) {
//                     min = nums2[idxOfNums2];
//                 }
//             }
//         }

//         return res;
    }
}
