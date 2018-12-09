class NumArray {
    int st[];
    int nums[];
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        this.n = nums.length;

        if (n > 0) {
            int x = (int) Math.ceil(Math.log(n) / Math.log(2));

            // maximum size of segment tree
            int maxSize = 2 * (int) Math.pow(2, x) - 1;

            this.st = new int[maxSize];

            constructSTUtil(this.nums, 0, n - 1, 0);
        } else {
            this.st = new int[0];
        }
    }

    private int getMid(int start, int end) {
        return start + (end - start) / 2;
    }

    int getSumUtil(int ss, int se, int qs, int qe, int si) {
        if (qs <= ss && qe >= se) {
            return st[si];
        }

        if (se < qs || ss > qe) {
            return 0;
        }

        int mid = getMid(ss, se);
        return getSumUtil(ss, mid, qs, qe, 2 * si + 1) +
               getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
    }

    void updateValueUtil(int ss, int se, int i, int diff, int si) {
        if (i < ss || i > se) {
            return ;
        }

        st[si] += diff;
        if (se != ss) {
            int mid = getMid(ss, se);
            updateValueUtil(ss, mid, i, diff, 2 * si + 1);
            updateValueUtil(mid + 1, se, i ,diff, 2 * si + 2);
        }
    }

    void updateValue(int[] nums, int n, int i, int newVal) {
        if (i < 0 || i > n - 1) {
            System.out.println("Invalue input");
            return;
        }

        int diff = newVal - nums[i];

        // update the value in the array
        nums[i] = newVal;

        updateValueUtil(0, n - 1, i, diff, 0);
    }

    int getSum(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            throw new IllegalArgumentException("Invalid query");
        }
        return getSumUtil(0, n - 1, qs, qe, 0);
    }

    int constructSTUtil(int[] nums, int ss, int se, int si) {
        if (ss == se) {
            st[si] = nums[ss];
            return nums[ss];
        }

        int mid = getMid(ss, se);
        st[si] = constructSTUtil(nums, ss, mid, 2 * si + 1) +
                 constructSTUtil(nums, mid + 1, se, 2 * si + 2);
        return st[si];
    }

    public void update(int i, int val) {
        updateValue(this.nums, this.nums.length, i, val);
    }

    public int sumRange(int i, int j) {
        return this.getSum(this.nums.length, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
