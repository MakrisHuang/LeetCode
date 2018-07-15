class Solution {
    class Node {
        int room;
        List<Integer> keys;
        Node (int room, List<Integer> keys) {
            this.room = room;
            this.keys = keys;
        }
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return false;

        boolean[] visited = new boolean[rooms.size()];
        for (int i = 0; i < visited.length; i++) { visited[i] = false; }

        Stack<Node> st = new Stack<>();
        st.push(roomToNode(rooms, 0));
        while (! st.isEmpty()) {
            Node node = st.pop();
            if (! visited[node.room]) {
                visited[node.room] = true;
                for (Integer roomNum: node.keys) {
                    st.push(roomToNode(rooms, roomNum));
                }
            }
        }
        for (int i = 0; i < visited.length; i++) {
            if (! visited[i]) return false;
        }
        return true;
    }

    private Node roomToNode(List<List<Integer>> rooms, int idx) {
        return new Node (idx, rooms.get(idx));
    }
}
