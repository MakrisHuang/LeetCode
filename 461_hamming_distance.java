class Solution {
    public int hammingDistance(int x, int y) {
        // since 0 ^ 1 = 1, we can XOR them
        // and count the number of 1's in the result
        int result = x ^ y;

        int count = 0;

        while (result != 0){
            ++count;
            result = (result - 1) & result;
        }

        return count;
    }
}
