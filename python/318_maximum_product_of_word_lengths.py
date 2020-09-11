class Solution:
    # use bit manipulation
    # adding the bit of a character into a single number
    # if nums[i] & nums[j] == 0 (no common words), we can use it as the candidate
    def maxProduct(self, words: List[str]) -> int:
        bit_nums = [0 for _ in range(len(words))]
        for i, word in enumerate(words):
            for c in word:
                bit_nums[i] = bit_nums[i] | (1 << ord(c) - ord('a'))

        longest = 0
        for i in range(len(words)):
            for j in range(i + 1, len(words)):
                if bit_nums[i] & bit_nums[j] == 0:
                    longest = max(longest, len(words[i]) * len(words[j]))
        return longest
