class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i], i);
        }
        int[] result = new int[A.length];
        for (int j = 0; j < A.length; j++) {
            result[j] = map.get(A[j]);
        }
        return result;
    }
}
