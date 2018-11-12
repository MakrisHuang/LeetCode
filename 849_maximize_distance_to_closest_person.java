class Solution {
    // n: number of empty seats, m: number of non-empty seats
    // for each empty seat, we try to find the closest non-empty
    // in worse case, we may traverse all seats
    // therefore, the time complexity is O(n * (n + m))
    // space complexity: O(1)
    public int maxDistToClosest(int[] seats) {
        int maxDist = 0;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 0) {
                int left = i, right = i;
                
                while (left > 0 && seats[left] == 0) left--;
                while (right < seats.length - 1 && seats[right] == 0) right++;
                int distLeft = (seats[left] == 1) ? Math.abs(left - i) : Integer.MAX_VALUE;
                
                int distRight = (seats[right] == 1) ? Math.abs(right - i) : Integer.MAX_VALUE;
                
                int minDist = Math.min(distLeft, distRight);
                maxDist = Math.max(maxDist, minDist);
            }
        }
        return maxDist;
    }
    
    // Time Complexity : O(n)
    // Space Complexity: O(n)
    // left[i] be the distance from seat i to the closest person sitting to the left of i. Similarly, let right[i] be the distance to the closest person sitting to the right of i
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        int[] left = new int[len], right = new int[len];
        Arrays.fill(left, len);
        Arrays.fill(right, len);

        for (int i = 0; i < len; ++i) {
            if (seats[i] == 1) left[i] = 0;
            else if (i > 0) left[i] = left[i - 1] + 1;
        }

        for (int i = len - 1; i >= 0; --i) {
            if (seats[i] == 1) right[i] = 0;
            // ex.      0 1 1 1 0
            // then:    1 0 0 0 len
            else if (i < len - 1) right[i] = right[i + 1] + 1;
        }

        int ans = 0;
        for (int i = 0; i < len; ++i)
            if (seats[i] == 0)
                ans = Math.max(ans, Math.min(left[i], right[i]));
        return ans;
    }
}