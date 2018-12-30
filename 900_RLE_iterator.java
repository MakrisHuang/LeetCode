class RLEIterator {
    int[] A;
    int amountIdx, accumulated;

    public RLEIterator(int[] A) {
        this.A = A;
        amountIdx = accumulated = 0;
    }

    public int next(int n) {
        while (amountIdx < A.length) {
            if (accumulated + n > A[amountIdx]) {
                // because accumulated + n > A[amountIdx]
                // such that A[amountIdx] - accumulated < n
                // we first reduce `accumulated` from A[amountIdx]
                // then subtract n with remaining amount
                n -= (A[amountIdx] - accumulated);

                // with previous subtraction, there is no accumulated elements
                // set to 0
                accumulated = 0;

                // then move amountIdx forward to next amount
                amountIdx += 2;
            } else {
                accumulated += n;
                return A[amountIdx + 1];
            }
        }

        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(A);
 * int param_1 = obj.next(n);
 */
