class Solution {
    // Time Complexity: O(nlogn)
    // Space Complexity: O(1)
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort((t1, t2) -> {
            return t1.compareTo(t2);
        });

        int ans = Integer.MAX_VALUE;
        for (int i = timePoints.size() - 1; i > 0; i--) {
            String t1 = timePoints.get(i);
            String t2 = timePoints.get(i - 1);
            ans = Math.min(ans, calDiff(t1, t2));
        }

        // compare the first one and last one
        if (timePoints.size() > 1) {
            String t1 = timePoints.get(timePoints.size() - 1);
            int min1 = calMin(t1);
            String t2 = timePoints.get(0);
            int min2 = calMin(t2);
            int diff = (24 * 60 - min1) + min2;
            ans = Math.min(ans, diff);
        }

        return ans;
    }

    public int calDiff(String t1, String t2) {
        int min1 = calMin(t1);
        int min2 = calMin(t2);
        return Math.abs(min1 - min2);
    }

    public int calMin(String time) {
        String[] timePair = time.split(":");
        return Integer.valueOf(timePair[0]) * 60 + Integer.valueOf(timePair[1]);
    }
}
