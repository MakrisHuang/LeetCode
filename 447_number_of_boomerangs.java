class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0 || points[0].length < 2) return 0;
        int numPoints = points.length, count = 0;
        for (int i = 0; i < numPoints; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < numPoints; j++) {
                if (i == j) continue;
                Integer d = dist(points[i], points[j]);
                Integer v = map.get(d);
                if (v == null) map.put(d, 1);
                else map.put(d, v + 1);
            }
            for (Map.Entry<Integer, Integer> e: map.entrySet()) {
                if (e.getValue() > 1) {   // we found another points whose distance identical to previous, so make permutation here
                    int value = e.getValue();
                    int permutation = value * (value - 1);
                    count += permutation;
                }
            }
            map = null;
        }
        return count;
    }

    private Integer dist(int[] a, int[] b) {
        int x = Math.abs(a[0] - b[0]);
        int y = Math.abs(a[1] - b[1]);
        return x * x + y * y;
    }
}
