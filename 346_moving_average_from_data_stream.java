class MovingAverage {

    Deque<Integer> queue;
    int size;

    public MovingAverage(int size) {
        this.queue = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size() == this.size) {
            queue.pollFirst();
        }
        queue.offerLast(val);
        double result = 0.0;
        for (int num: queue) result += (double)num;
        return result / queue.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
