class Solution {
    // note: consider corner case: [[1], [1], [1]] and [[1,1], [1,1], [1,1]]
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> appearMap = new HashMap<>();
        for (List<Integer> row: wall) {
            // add the rest
            if (row.size() > 1) {
                appearMap.put(row.get(0), appearMap.getOrDefault(row.get(0), 0) + 1);
                for (int i = 1; i < row.size() - 1; i++) {
                    int accumulatedLen = row.get(i) + row.get(i - 1);
                    row.set(i, accumulatedLen);
                    appearMap.put(accumulatedLen, appearMap.getOrDefault(accumulatedLen, 0) + 1);
                }
            }
        }
        
        // iterate all accumulated length in map
        int maxOverlappingTimes = 0;
        for (Map.Entry<Integer, Integer> entry: appearMap.entrySet()) {
            if (entry.getValue() > maxOverlappingTimes) {
                maxOverlappingTimes = entry.getValue();
            }
        }
        
        return wall.size() - maxOverlappingTimes;
    }
}