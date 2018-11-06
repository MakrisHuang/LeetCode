class Solution {
    int total = 0;
    int[] pre;
    Random rand = new Random();

    public Solution(int[] w) {
        for (int weight: w) total += weight;

        pre = w.clone();

        // sum them up
        // ex. [1, 2, 1, 3, 3] -> [1, 3, 4, 7, 10]
        for (int i = 1; i < pre.length; i++) {
            pre[i] += pre[i - 1];
        }
    }

    public int pickIndex() {
        int target = rand.nextInt(this.total);
        int low = 0, high = this.pre.length - 1;
        // ex. 1, 3, 6 -> 1, 4, 10
        // rand = 2
        // low = 0, high = 2, mid = 1
        // target = 8 => low = mid + 1 = 2
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (this.pre[mid] <= target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
