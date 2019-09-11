class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int count = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < dominoes.length; i++) {
            int[] row = dominoes[i];
            Arrays.sort(row);
            String key = row[0] + "_" + row[1];
            System.out.println(key);
            countMap.put(key, countMap.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> e: countMap.entrySet()) {
            int times = e.getValue();
            if (times >= 2) {
                int tempCount = times * (times - 1) / 2;
                count += tempCount;
            }
        }
        return count;
    }
}
