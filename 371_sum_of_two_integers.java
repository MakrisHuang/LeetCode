class Solution {
    // recursion
    public int getSum_recursion(int p, int q) {
        int result = p ^ q; // + without carry 0+0=0, 0+1=1+0=1, 1+1=0
        int carry = (p & q) << 1; // 1+1=2
        if (carry != 0) {
            return getSum(result, carry);
        }
        return result;
    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
