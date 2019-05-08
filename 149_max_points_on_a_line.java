class Solution {

    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Time Complexity: O(n ^ 2)
    // Space Complexity: O(n) (track n - 1 lines)
    public int maxPoints(int[][] points) {
        // initiate points into Point class
        if (points == null || points.length == 0 || points[0].length == 0) return 0;
        Point[] ps = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            ps[i] = new Point(points[i][0], points[i][1]);
        }

        int solution = 0;

        // calculate slope for each pair
        for (int i = 0; i < ps.length; i++) {
            Point p1 = ps[i];
            // the map is for current p1
            // s.t. map is an internal variable
            // then I don't have to recalculate after the outer for loop
            Map<String, Integer> countMap = new HashMap<>();
            int duplicate = 0;
            int max = 0;
            for (int j = i + 1; j < ps.length; j++) {
                Point p2 = ps[j];
                int deltaX = p2.x - p1.x;
                int deltaY = p2.y - p1.y;

                if (deltaX == 0 && deltaY == 0) {
                    duplicate++;
                    continue;
                }

                int gcd = gcd(deltaX, deltaY);
                int dX = deltaX / gcd;
                int dY = deltaY / gcd;

                String key = dX + "," + dY;
                countMap.put(key,
                    countMap.getOrDefault(key, 0) + 1);
                max = Math.max(max, countMap.get(key));
            }

            solution = Math.max(solution, max + duplicate + 1);
        }
        return solution;
    }

    // GCD prototype
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
