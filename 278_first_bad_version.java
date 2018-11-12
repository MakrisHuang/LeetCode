/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int res = 0;
        
        int left = 1, right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    /*
    1 2 3 4 5 6, first = 3
        left = 1, right = 6, mid = 3
        isBad(3) => right = 3
        left = 1, right = 3, mid = 2
        isBad(2) => left = 3
    */
}