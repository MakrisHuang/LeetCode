class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = 2 * nums.length - 1; i >= 0; i--) {
            while (st.size() != 0 && nums[i % nums.length] >= nums[st.peek()]) {
                st.pop();
            }
            res[i % nums.length] = (st.size() == 0) ? -1 : nums[st.peek()];
            st.push(i % nums.length);
        }
        return res;
    }

//     public int[] nextGreaterElements(int[] nums) {
//         int[] res = new int[nums.length];

//         for (int i = 0; i < nums.length; i++) {
//             int num = nums[i];

//             // search for all next greater number circularly
//             int greater = Integer.MIN_VALUE;
//             for (int start = i + 1; start < nums.length; start++) {
//                 if (nums[start] > num && greater == Integer.MIN_VALUE) {
//                     greater = nums[start];
//                     break;
//                 }
//             }
//             for (int start = 0; start < i; start++) {
//                 if (nums[start] > num && greater == Integer.MIN_VALUE) {
//                     greater = nums[start];
//                     break;
//                 }
//             }
//             res[i] = (greater == Integer.MIN_VALUE) ? -1 : greater;
//         }
//         return res;
//     }
}
