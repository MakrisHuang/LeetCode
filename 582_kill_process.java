class Solution {
    // HashMap + DFS
    // Time Complexity: O(n)
    // Space Complexity: O(n) (map size)
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> l = map.getOrDefault(ppid.get(i), new ArrayList<>());
                l.add(pid.get(i));
                map.put(ppid.get(i), l);
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(kill);
        getAllChildren(map, res, kill);
        return res;
    }
    
    public void getAllChildren(Map<Integer, List<Integer>> map, List<Integer> res, int kill) {
        if (map.containsKey(kill)) {
            for (int id: map.get(kill)) {
                res.add(id);
                getAllChildren(map, res, id);
            }
        }
    }
    // Time Complexity: O(n^n)
//     public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
//         List<Integer> res = new ArrayList<>();
//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] ppidVisited = new boolean[ppid.size()];
        
//         // initialize the queue
//         queue.offer(kill);
//         while (!(queue.size() == 0)) {
//             int parentId = queue.poll();
//             res.add(parentId);
            
//             // add the pids corresponding to ppid
//             for (int i = 0; i < pid.size(); i++) {
//                 if (ppid.get(i) == parentId && !ppidVisited[i]) {
//                     ppidVisited[i] = true;
//                     queue.offer(pid.get(i));
//                 }
//             }
//         }
//         return res;
//     }
}