class Solution {
    // Time Complexity: O(log(n) + k)
    // Space Complexity: O(k)   (for generate k eles sub list)
    public List<Integer> findClosestElements(int[] src, int k, int x) {
        int idx = findClosestIndex(src, x);

        List<Integer> arr = new ArrayList<>();
        for (int val: src) arr.add(val);

        if (idx < 0) {
            return arr.subList(0, k);
        } else if (idx >= src.length) {
            return arr.subList(src.length - k, src.length);
        } else {
            // initialize maximum low index (not smaller than 0)
            // and minimum high index (not larger than the length of this array)
            int low = Math.max(0, idx - k - 1), high = Math.min(src.length - 1, idx + k + 1);
            while (high - low + 1 > k) {
                // 程式簡化：考慮 range 的變化，共兩大種類，其中可細分出四種case
                // shrink high if left elements are closer in difference
                if (low < 0 || (x - src[low] <= src[high] - x)) {
                    // if low >= 0 -> smaller eles are available -> high--
                    high--;
                } else if (high > src.length - 1 || (x - src[low] > src[high] - x)) {
                    // if smaller elements are not available
                    // also if high < src.length -> use large elements
                    low++;
                }
            }
            return arr.subList(low, high + 1);
        }
    }

    public int findClosestIndex(int[] arr, int x) {
        int lo = 0, hi = arr.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] > x) {
                hi = mid - 1;
            } else if (arr[mid] < x) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
}
