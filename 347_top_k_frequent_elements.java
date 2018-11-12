class Solution {
    class Node {
        int val;
        int occurences;
        Node(int val, int occurences) {
            this.val = val;
            this.occurences = occurences;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        for (int num: nums) {
            if (nodeMap.containsKey(num)) {
                Node currNode = nodeMap.get(num);
                currNode.occurences += 1;
                nodeMap.put(num, currNode);
            } else {
                nodeMap.put(num, new Node(num, 1));
            }
        }
        
        PriorityQueue<Node> queue = new PriorityQueue<Node>((node1, node2) -> {
           return node2.occurences - node1.occurences; 
        });
        for (Map.Entry<Integer, Node> entry: nodeMap.entrySet()) {
            queue.offer(entry.getValue());
        }
        
        List<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(queue.poll().val);
            k--;
        }
        return res;
    }
}