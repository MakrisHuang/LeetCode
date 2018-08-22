class HitCounter {
    public static final int interval = 300;
    int currTime;
    int numEles;
    Deque<Integer> queue;
    public HitCounter() {
        currTime = Integer.MIN_VALUE;
        numEles = 0;
        queue = new LinkedList<>();
    }

    /** Record a hit.
        @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        queue.offerLast(timestamp);
        numEles++;
        currTime = timestamp;
    }

    /** Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (!queue.isEmpty()) {
            int val = queue.peekFirst();
            if (timestamp - val >= interval) {
                queue.pollFirst();
                numEles--;
            } else {
                break;
            }
        }
        return this.numEles;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
