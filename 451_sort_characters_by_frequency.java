class Solution {
    private class Node {
        Character c;
        Integer count;
        Node(Character c, Integer count) {
            this.c = c;
            this.count = count;
        }
    }

    PriorityQueue<Node> queue;
    Map<Character, Node> map;

    public String frequencySort(String s) {
        if (s == null) return null;
        if (s.length() == 0) return s;

        map = new HashMap<Character, Node>();
        for (int i = 0; i < s.length(); i++) {
            Character c = Character.valueOf(s.charAt(i));
            Node node = null;
            if (map.containsKey(c)) {
                node = map.get(c);
                node.count = node.count + 1;
            } else {
                node = new Node(c, 1);
            }
            map.put(c, node);
        }

        TimesComparator comparator = new TimesComparator();
        queue = new PriorityQueue(11, comparator);
        for (Map.Entry<Character, Node> entry : map.entrySet()){
            Node node = entry.getValue();
            queue.add(node);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for (int i = 1; i <= node.count; i++) {
                sb.append(node.c);
            }
        }
        return sb.toString();
    }

    private class TimesComparator implements Comparator<Node> {
        @Override
        public int compare(Node x, Node y) {
            if (x.count < y.count) return 1;
            else if (x.count > y.count) return -1;
            else return 0;
        }
    }
}
