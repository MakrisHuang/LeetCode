class KthLargest {

    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>(k);
        this.k = k;     // must assign first before call add
        for (int num: nums) {
            add(num);
        }
    }

    public int add(int n) {
        q.offer(n);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
