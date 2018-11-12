class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] res = new int[A.length][B[0].length];
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < B[0].length; col++) {
                int sum = 0;
                for (int time = 0; time < B.length; time++) {
                    sum +=  A[row][time] * B[time][col];
                }
                res[row][col] = sum;
            }
        }
        return res;
    }
}