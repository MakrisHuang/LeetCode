class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            res.add(getRange((long)lower - 1, (long)upper + 1));
            return res;
        }
        
        for (int i = 0; i <= nums.length; i++) {
            String range = "";
            if (i == 0) {
                range = getRange((long)lower - 1, (long)nums[i]);
            } else if (i == nums.length) {
                range = getRange((long)nums[i - 1], (long)upper + 1);
            } else {
                range = getRange((long)nums[i - 1], (long)nums[i]);
            }
            if (! range.isEmpty()) {
                res.add(range);
            }
        }
        return res;
    }
    
    private String getRange(long left, long right) {
        long diff = right - left;
        if (diff <= 1) {
            return "";
        } else if (diff == 2) {
            return String.valueOf(left + 1);
        } else {
            return String.valueOf(left + 1) + "->" + String.valueOf(right - 1);
        }
    }
}