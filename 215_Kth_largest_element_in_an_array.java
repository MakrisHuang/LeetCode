class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> {
            return o2 - o1;
        });
        for (int num: nums) {
            queue.offer(num);
        }
        
        // retrieve k-th elements
        int ans = 0;
        while (k > 0) {
            ans = queue.poll();
            k--;
        }
        return ans;
    }
}