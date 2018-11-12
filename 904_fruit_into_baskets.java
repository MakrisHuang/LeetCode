class Solution {
    // Time Complexity: O(n)
    // 1 3 1 3 1 2 3 1
    // index i keeps the fruit needed to be dropped
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> map = new HashMap<>(); // key: position, value: num of fruits
        
        // Step 1. update fruit amount by index
        int curr = 0, max = 0;
        for (int i = 0; i < tree.length; i++) {
            map.put(tree[i], map.getOrDefault(tree[i], 0) + 1);
            // Step 2. move to the position where only 2 kinds of fruits in hand
            while (map.size() >= 3) {
                int currAmount = map.get(tree[curr]);
                currAmount--;
                if (currAmount == 0) {
                    map.remove(tree[curr]);
                } else {
                    map.put(tree[curr], currAmount);
                }
                curr++;
            }
            max = Math.max(max, i - curr + 1);
        }
        return max;
    }
    
    // Time Complexity: O(n ^ 2)
//     public int totalFruit(int[] tree) {
//         int max = 0;
//         for (int i = 0; i < tree.length; i++) {
//             Map<Integer, Integer> map = new HashMap<>();    // tree type: is selected
//             int fruits = 0;

//             for (int curr = i; curr < tree.length; curr++) {
//                 int treeType = tree[curr];

//                 if (map.size() < 2 || map.containsKey(treeType)) {
//                     // add new fruit
//                     map.put(treeType, map.getOrDefault(treeType, 0) + 1);
//                     fruits++;
                    
//                 } else {
//                     break;
//                 }
//             }
//             max = Math.max(max, fruits);
//         }
//         return max;
//     }
}