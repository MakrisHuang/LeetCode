class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.get(triangle.size() - 1).size();
        int[] dp = new int[size];
        List<Integer> list = null;
        int subSize = 0;    int x = 0;
        for(int i = triangle.size() - 1; i >= 0; i--){
            list = triangle.get(i);
            subSize = list.size();
            if(i == triangle.size() - 1){
                for(int k = subSize - 1; k >= 0; k--){
                    dp[k] = list.get(k);
                }
            }else{
                for(int k = 0; k <= subSize - 1; k++){
                    x = list.get(k);
                    dp[k] = Math.min(x + dp[k], x + dp[k + 1]);
                }
            }
        }
        return dp[0];
    }
}
