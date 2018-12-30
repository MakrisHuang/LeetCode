class Solution {
    // Time Complexity: O(len(B) * (len(A) + len(B)))
    // Space Complexity: O(len(A) + len(B))

    // we append A until new string is long enough to contain B
    // if we cannot find appropriate new string, append A again
    // since new string is long enough, we just need to check `times` and `times + 1`
    public int repeatedStringMatch(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) return -1;

        StringBuilder sb = new StringBuilder(A);
        int times = 1;
        for(; sb.length() < B.length(); times++) sb.append(A);
        if (sb.indexOf(B) != -1) return times;
        if (sb.append(A).indexOf(B) != -1) return times + 1;
        return -1;
    }
}
