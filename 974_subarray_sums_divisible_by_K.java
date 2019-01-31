class Solution {
    // Key Point: store mod as Key, count as Value
    // once we have the same mod, means the range from previous one to curr is divisble to K
    // so we add 1 to the value given this key
    public int subarraysDivByK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int res = 0;

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            int mod = sum % K;
            if (mod < 0) mod += K;
            int count = map.getOrDefault(mod, 0);
            res += count;
            map.put(mod, count + 1);
        }
        return res;
    }
}
