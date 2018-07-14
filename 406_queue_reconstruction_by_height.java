class Solution {
    public int[][] reconstructQueue(int[][] people) {
        // sort the array, the tallest must come first
        // and for k, higher k will stand behind
        // see discussion for more details
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> list = new LinkedList<>();
        for (int[] p : people) {
            // insert by k -> means there will be k people stand in front of that person
            list.add(p[1], p);
        }
        return list.toArray(new int[list.size()][]);
    }
}
