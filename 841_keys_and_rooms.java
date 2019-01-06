class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        dfsVisit(rooms, visited, 0);
        for (int room = 0; room < rooms.size(); room++) {
            if (! visited[room]) return false;
        }
        return true;
    }
    
    public void dfsVisit(List<List<Integer>> rooms, boolean[] visited, int curr) {
        if (visited[curr]) return;
        
        visited[curr] = true;
        List<Integer> keys = rooms.get(curr);
        for (int key: keys) {
            dfsVisit(rooms, visited, key);
        }
    }
    
    // stack solution
//     class Node {
//         int room;
//         List<Integer> keys;
//         Node (int room, List<Integer> keys) {
//             this.room = room;
//             this.keys = keys;
//         }
//     }

//     public boolean canVisitAllRooms(List<List<Integer>> rooms) {
//         if (rooms == null || rooms.size() == 0) return false;

//         boolean[] visited = new boolean[rooms.size()];
//         for (int i = 0; i < visited.length; i++) { visited[i] = false; }

//         Stack<Node> st = new Stack<>();
//         st.push(roomToNode(rooms, 0));
//         while (! st.isEmpty()) {
//             Node node = st.pop();
//             if (! visited[node.room]) {
//                 visited[node.room] = true;
//                 for (Integer roomNum: node.keys) {
//                     st.push(roomToNode(rooms, roomNum));
//                 }
//             }
//         }
//         for (int i = 0; i < visited.length; i++) {
//             if (! visited[i]) return false;
//         }
//         return true;
//     }

//     private Node roomToNode(List<List<Integer>> rooms, int idx) {
//         return new Node (idx, rooms.get(idx));
//     }
}