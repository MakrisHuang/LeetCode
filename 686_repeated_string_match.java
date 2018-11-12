class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) return -1;
        StringBuilder sb = new StringBuilder(A);
        int q = 1;
        for(; sb.length() < B.length(); q++) sb.append(A);
        if (sb.indexOf(B) != -1) return q;
        if (sb.append(A).indexOf(B) != -1) return q + 1;
        return -1;
    }
}