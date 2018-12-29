class Solution {
    public int[] diStringMatch(String S) {
        int low = 0, high = S.length();
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                res.add(low++);
            } else {
                res.add(high--);
            }
        }
        res.add(low);
        return res.stream().mapToInt(i -> i).toArray();
    }
}
