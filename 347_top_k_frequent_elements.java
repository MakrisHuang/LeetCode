class Solution {
    class Node {
        int value;
        int count;
        Node (int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.count - o1.count;
            }
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(comparator);

        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            queue.offer(node);
        }

        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty() && k > 0) {
            result.add(queue.poll().value);
            k--;
        }
        return result;
    }
}
