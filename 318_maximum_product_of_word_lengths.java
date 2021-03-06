class Solution {
    public int maxProduct(String[] words) {
        int len = words.length, maxProduct = 0;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            for (char ch: words[i].toCharArray()) {
                // is using bit to represent if a char exists in the word. For example, if a and b exists, it will be 11 (binary).
                nums[i] = nums[i] | (1 << (ch -'a'));
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if ((nums[i] & nums[j]) == 0) {
                    maxProduct = Math.max(maxProduct, words[i].length() * words[j].length());
                }
            }
        }
        return maxProduct;
    }
}
