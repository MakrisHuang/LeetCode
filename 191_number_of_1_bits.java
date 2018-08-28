public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count;
        for (count = 0; n != 0; count++) {
            n &= n - 1;
        }
        return count;
    }
}
