class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (a, b) -> a[1] - b[1]);
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;

//         for given n ballons, the max arrow used would be n
//         1. find intervals with least overlapped
//         ex. [1, 6] + [2, 8] => [2, 6]

//         create possible intervals for burst ballons
//         List<List<Integer>> intervals = new ArrayList<>();
//         for (int row = 0; row < points.length - 1; row += 2) {
//             int nextRow = row + 1;
//             int v1End = points[row][1], v2Start = points[nextRow][0];
//             if (v1End >= v2Start) {
//                 List<Integer> interval = new ArrayList<>(Arrays.asList(v2Start, v1End));
//                 intervals.add(interval);
//             } else {
//                 List<Integer> ballon1 = new ArrayList<>(Arrays.asList(points[row][0], points[row][1]));
//                 List<Integer> ballon2 = new ArrayList<>(Arrays.asList(points[nextRow][0], points[row][1]));
//                 intervals.add(ballon1);
//                 intervals.add(ballon2);
//             }
//         }

//         // use dynamic programming and greedy algorithm for calculate min arrows used
//         // at most we need the number of arrows = the number of ballons
//         int[] arrows = new int[points.length];
//         backtrack(intervals, numOf)
    }

//     private void backtrack(List<List<Integer>> intervals,
//                            final int[] numOfPossBurstsList, int[] arrows) {
//         for (int i = 0; i < ; ) {
//             arrows[i] = Math.min(arrows[i], arrows[i] + 1);
//         }

//     }

//     private boolean isBurst(List<Integer> point, int x) {
//         if (point.get(0) <= x && x >= point.get(1)) return true;
//         else return false;
//     }

//     private boolean isBurstWithInterval(List<Integer> point, List<Integer> interval) {
//         int pointStart = point.get(0), pointEnd = point.get(1);
//         int intervalStart = interval.get(0), intervalEnd = interval.get(1);
//         return (pointStart <= intervalEnd || pointEnd >= intervalStart);
//     }

//     // this function records given a interval that
//     // how many ballons can be bursted
//     // ex given [2, 6], for 2 ballons [1,6], [2, 8], [7, 9] -> 2 ballons will be bursted
//     private int[] numOfPossibleBallon(List<List<Integer>> intervals, int[][] points) {
//         int[] numOfPossBurstsList = new int[intervals.size()];
//         for (int intervalRow = 0; intervalRow < intervals.size(); intervalRow++) {
//             int numOfPossBursts = 0;
//             List<Integer> interval = intervals.get(intervalRow);
//             for (int row = 0; row < points.length; row++) {
//                 int pointStart = points[row][0], pointEnd = points[row][1];
//                 List<Integer> point = new ArrayList<>(Arrays.asList(pointStart, pointEnd));
//                 if (isBurstWithInterval(point, interval)) numOfPossBursts++;
//             }
//             numOfPossBurstsList[intervalRow] = numOfPossBursts;
//         }
//         return numOfPossBurstsList;
//     }
}

