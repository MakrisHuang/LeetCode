class Solution {
    public int leastInterval(char[] tasks, int n) {
//         Map<Character, Integer> map = new HashMap<>();
//         // Stack<Character> singleSt = new Stack<>();

//         for (Character c: tasks) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//         }

//         int numTasks = tasks.length;
//         int numIntervals = (numTasks - 1) * n;
//         int[] res = new int [numTasks + numIntervals];

//         for (Map.Entry<Character, Integer> entry: map.entrySet()) {

//         }
        int[] c = new int[26];
        for (char t: tasks) {
            c[t - 'A'] += 1;
        }
        Arrays.sort(c);

        int frameIdx = 25;
        while (frameIdx >= 0 && c[frameIdx] == c[25]) frameIdx--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + (25 - frameIdx));
    }
}
