class Solution {
    PriorityQueue<Integer> queue;

    public int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || nums.length < k) return 0;
        queue = new PriorityQueue<>(k, comparator);

        for (int num: nums) {
            if (queue.size() < k) {
                queue.add(num);
            } else {
                // check current num is larger than
                // the one in our queue
                if (num > queue.peek()) {
                    queue.poll();
                    queue.add(num);
                }
            }
        }
        int largest = queue.peek();
        return largest;
    }

    private static Comparator<Integer> comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    };
}
