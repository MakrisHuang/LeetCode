class Solution {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int compress(char[] chars) {
        int orig = 0, curr = 0;
        while (curr < chars.length) {
            int next = curr;
            char ch = chars[curr];
            while (next < chars.length && ch == chars[next]) {
                next++;
            }

            // set new character to curr position
            chars[orig] = chars[curr];

            int amount = next - curr;
            if (amount > 1) {
                char[] amountArr = String.valueOf(amount).toCharArray();
                orig++;     // move to next position to store number
                for (int i = 0; i < amountArr.length; i++) {
                    chars[orig + i] = amountArr[i];
                }
                orig += amountArr.length;
            } else {
                orig += 1;
            }

            // reset curr with the index of new character
            curr = next;
        }
        return orig;
    }
}
