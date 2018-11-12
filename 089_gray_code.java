class Solution {
    // use dynamic programming as our solution
    // initialization: f(1) = 0, 1
    // f(2) = 0 append f(1) + 1 append f(1) = (00, 01) + (10, 11)
    // f(n) = n-length gray codes = 0 append f(n-1) + 1 append f(n-1)
    // complexity: O(2 ^ n)
    public List<Integer> grayCode(int n) {
        if (n == 0) return new ArrayList<Integer>(Arrays.asList(0));

        List<List<String>> dp = new ArrayList<>();
        dp.add(new ArrayList<>(Arrays.asList("0", "1")));   // initialization
        calGray(dp, 1, n);
        List<String> layer = dp.get(n - 1);

        List<Integer> result = new ArrayList<>();
        for (String str: layer) {
            result.add(binaryToInt(str));
        }
        return result;
    }

    private void calGray(List<List<String>> dp, int level, int n) {
        if (level == n) return;

        List<String> prev = dp.get(level - 1);
        List<String> codes = new ArrayList<>();
        for (int i = 0; i < prev.size(); i++) {
            codes.add("0" + prev.get(i));
        }
        for (int j = prev.size() - 1; j >= 0; j--) {
            codes.add("1" + prev.get(j));
        }

        dp.add(codes);
        level++;
        calGray(dp, level, n);
    }

    private Integer binaryToInt(String binStr) {
        int result = 0;
        int len = binStr.length();
        for (int i = 0; i < len; i++) {
            if (binStr.charAt(i) == '1') {
                result += Math.pow(2, len - i - 1);
            }
        }
        return result;
    }
}
