class Solution:
    def longestStrChain(self, words: List[str]) -> int:
        # break if lengths are different
        def isPredecessor(word1, word2):
            if len(word1) + 1 != len(word2): return False
            i = 0
            for c in word2:
                if i == len(word1): return True
                if word1[i] == c:
                    i += 1
            return i == len(word1)

        words.sort(key= lambda x: len(x))

        occurrences = [0 for _ in range(len(words))]
        for i, curr in enumerate(words):
            longest = 0
            for j in range(0, i):
                prev = words[j]
                # check if the prev can form the current word
                if isPredecessor(prev, curr):
                    longest = max(longest, occurrences[j])
            occurrences[i] = longest + 1
        return max(occurrences)
