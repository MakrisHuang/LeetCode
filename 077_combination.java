class Solution {
    public List<List<Integer>> combine(int n, int k) {
        if (k > n) return null;
        List<List<Integer>> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), n, k, 1);
        return res;
    }
    
    public void backtrace(List<List<Integer>> res, List<Integer> temp, int n, int k, int start) {
        if (temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= n; i++) {
            temp.add(i);
            backtrace(res, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}