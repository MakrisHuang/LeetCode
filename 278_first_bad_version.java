/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 0) return -1;
        if (n == 1) return 1;
        int L = 1, R = n;
        while (L < R) {
            int M = L + (R - L) / 2;
            if (isBadVersion(M) == true) {
                R = M; // could be the last bad version
            } else {
                L = M + 1; // here we pass the false one, since next one could be a bad version
            }
        }
        return L;
    }
}