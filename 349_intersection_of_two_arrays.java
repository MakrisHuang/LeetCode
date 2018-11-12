class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> commonSet = new HashSet<>();
        for (int num1: nums1) {
            commonSet.add(num1);
        }
        
        Set<Integer> nums2Set = new HashSet<>();
        for (int num2: nums2) {
            nums2Set.add(num2);
        }
        
        List<Integer> res = new ArrayList<>();
        for (int num2: nums2Set) {
            if (commonSet.contains(num2)) {
                res.add(num2);
            }
        }
        
        int[] common = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            common[i] = res.get(i);
        }
        return common;
    }
}