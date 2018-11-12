class Solution {
    // Time complexity: O(len of nums1 + len of nums2)
    // Space complexity: O(len of nums1 + len of nums2)
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Map<Integer, List<Integer>> occurMap = new HashMap<>();
        
        countOccurances(occurMap, nums1, 0);
        countOccurances(occurMap, nums2, 1);
        
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry: occurMap.entrySet()) {
            List<Integer> occurTimes = entry.getValue();
            
            int occurTimes1 = occurTimes.get(0), occurTimes2 = occurTimes.get(1);
            if (occurTimes1 != 0 && occurTimes2 != 0) {
                int minTimes = Math.min(occurTimes1, occurTimes2);
                while (minTimes-- > 0) {
                    res.add(entry.getKey());
                }
            }
        }
        return res.stream().mapToInt(i->i).toArray();
    }
    
    private void countOccurances(Map<Integer, List<Integer>> occurMap, int[] arr, int whichArr) {
        for (int num: arr) {
            if (occurMap.containsKey(num)) {
                List<Integer> occurs = occurMap.get(num);
                occurs.set(whichArr, occurs.get(whichArr) + 1);
            } else {
                Integer[] occurArr = new Integer[] {0, 0};
                occurArr[whichArr] = 1;
                occurMap.put(num, Arrays.asList(occurArr));
            }
        }
    }
}