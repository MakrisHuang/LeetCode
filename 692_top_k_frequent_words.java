class Solution {

    class Node {
        String word;
        int count;
        Node (String word, int count) {
            this.word = word;
            this.count = count;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        Comparator<Node> comparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.count == o2.count) {
                    return o1.word.compareTo(o2.word);
                }
                return o2.count - o1.count;
            };
        };
        PriorityQueue<Node> queue = new PriorityQueue<>(comparator);

        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            Node node = new Node(entry.getKey(), entry.getValue());
            queue.offer(node);
        }

        List<String> res = new ArrayList<>();
        while (!queue.isEmpty() && k-- > 0) {
            res.add(queue.poll().word);
        }
        return res;
    }
}
