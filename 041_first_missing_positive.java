class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // base case
        int contains = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                contains++;
                break;
            }
        }

        if (contains == 0) {
            return 1;
        }

        // nums = [1]
        if (n == 1) {
            return 2;
        }

        // Replace negative numbers, zeros,
        // and numbers larger than n by 1s.
        // After this convertion nums will contain
        // only positive numbers.
        for (int i = 0; i < n; i++) {
            if ((nums[i] <= 0) || (nums[i] > n)) {
                nums[i] = 1;
            }
        }

        // Use index as a hash key and number sign as a presence detector.
        // For example, if nums[1] is negative that means that number `1`
        // is present in the array.
        // If nums[2] is positive - number 2 is missing.
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            // If you meet number a in the array - change the sign of a-th element.
            // Be careful with duplicates : do it only once.
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = -Math.abs(nums[a]);
            }
        }

        // Now the index of the first positive number
        // is equal to first missing positive.
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }

        if (nums[0] > 0) return n;

        return n + 1;
    }
//     public int firstMissingPositive(int[] nums) {
//         if (nums == null || (nums.length == 1 && nums[0] != 1)) return 1;

//         LinkedList<Integer> queue = new LinkedList<>();
//         for (int num: nums) {
//             if (num <= 0) {
//                 continue;
//             }
//             if (queue.size() != 0) {
//                 int first = queue.peekFirst();
//                 if (num <= first) {
//                     queue.addFirst(num);
//                 }
//                 int last = queue.peekLast();
//                 if (num >= last) {
//                     queue.addLast(num);
//                 }
//             } else {
//                 queue.addFirst(num);
//             }
//         }
//         System.out.println("The list is:" + queue);

//         if (queue.size() != 0) {
//             if (queue.size() == 1) {
//                 int one = queue.peekFirst();
//                 return (one == 1) ? 2 : 1;
//             }
//             for (int i = 1; i < queue.size(); i++) {
//                 if (queue.get(i - 1) != i) {
//                     return i;
//                 }
//             }
//             // numbers are differ by 1
//             // return the last one
//             return queue.peekLast() + 1;
//         }
//         return 1;
//     }
}
