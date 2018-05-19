class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int idx = 0; idx < nums.length; ){
            String ele = String.valueOf(nums[idx]);
            int end = idx;
            while(end + 1 < nums.length && nums[end] + 1 == nums[end + 1]){
                end++;
            }
            if (idx != end){
                ele = ele + "->" + nums[end];
                idx = end;
            }
            idx++;
            result.add(ele);
        }
        return result;
    }
}
