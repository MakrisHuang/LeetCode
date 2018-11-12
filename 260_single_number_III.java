class Solution {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length < 2) return null;
        int xorResult = 0;
        for (int num: nums) {
            xorResult ^= num;
        }
        
        int indexOf1 = findFirstBitIs1(xorResult);
        int num1 = 0, num2 = 0;
        for (int j = 0; j < nums.length; j++) {
            // 將數組分群，第一群是位元中有 1 的
            // 同時把兩群的內容做 XOR 運算，出現兩次的會消掉
            // ex. [2, 4, 3, 6, 3, 2, 5, 5] -> [2, 3, 6, 3, 2] 和 [4, 5, 5]
            if (isBit1(nums[j], indexOf1)) {
                num1 ^= nums[j]; // 產生 6
            } else {
                num2 ^= nums[j]; // 產生 4
            }
        }
        
        int[] output = new int[2];
        output[0] = num1;
        output[1] = num2;
        return output;
    }
    
    private int findFirstBitIs1(int xorResult) {
        int indexBit = 0;
        // 持續移動位元，直到第一個位元為 1
        while ((xorResult & 1) == 0) {
            xorResult = xorResult >> 1;
            indexBit++;
        }
        return indexBit;
    }
    
    private boolean isBit1(int candidate, int indexBit) { // 檢查移動 indexBit 位後的第一個位元是否為 1
        candidate = candidate >> indexBit;
        return ((candidate & 1) == 1) ? true : false;
    }
}