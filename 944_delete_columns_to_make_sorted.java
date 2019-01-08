class Solution {
    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) return 0;
        int count = 0;
        int wordLen = A[0].length();
        for (int i = 0; i < wordLen; i++) {
            boolean nonDecreasing = true;

            int curr = A[0].charAt(i) - 'a';    // current alphabet order
            for (int next = 1; next < A.length; next++) {
                int order = A[next].charAt(i) - 'a';    // next order
                if (A[next].charAt(i) - 'a' < curr) {
                    nonDecreasing = false;
                    break;
                }
                // if still non-decreasing, update curr with order
                curr = order;
            }
            if (! nonDecreasing) {
                count++;
            }
        }
        return count;
    }
}
