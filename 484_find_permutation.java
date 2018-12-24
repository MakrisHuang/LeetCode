class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] findPermutation(String s) {
        int[] res = new int[s.length() + 1];
        Stack<Integer> st = new Stack<>();
        int j = 0;
        for (int i = 1; i <= s.length(); i++) {
            if (s.charAt(i - 1) == 'I') {
                st.push(i);
                while (st.size() != 0) {
                    res[j++] = st.pop();
                }
            } else {
                st.push(i);
            }
        }
        st.push(s.length() + 1);
        while (st.size() != 0) {
            res[j++] = st.pop();
        }
        return res;
    }

//     public int[] findPermutation(String s) {
//         List<List<Integer>> result = new ArrayList<>();
//         List<Integer> nums = new ArrayList<>();
//         for (int i = 1; i <= s.length() + 1; i++) {
//             nums.add(i);
//         }
//         backtrace(result, new ArrayList<>(), nums, s);

//         List<Integer> ans = result.get(0);
//         return ans.stream().mapToInt(i -> i).toArray();
//     }

//     public void backtrace(List<List<Integer>> res, List<Integer> temp, List<Integer> nums, String s) {
//         if (temp.size() == nums.size()) {
//             if (isValid(temp, s)) {
//                 res.add(new ArrayList<>(temp));
//             }
//         } else {
//             for (int i = 0; i < nums.size(); i++) {
//                 if (temp.contains(nums.get(i))) continue;
//                 temp.add(nums.get(i));
//                 backtrace(res, temp, nums, s);
//                 temp.remove(temp.size() - 1);
//             }
//         }
//     }

//     public boolean isValid(List<Integer> src, String s) {
//         for (int i = 1; i < src.size(); i++) {
//             int curr = src.get(i);
//             int prev = src.get(i - 1);
//             if (s.charAt(i - 1) == 'I' && prev > curr) {
//                 return false;
//             }
//             if (s.charAt(i - 1) == 'D' && prev < curr) {
//                 return false;
//             }
//         }
//         return true;
//     }
}
