class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        ans = 0
        heads = [[] for _ in range(26)]
        for word in words:
            it = iter(word)
            heads[ord(next(it)) - ord('a')].append(it)

        for letter in s:
            letter_idx = ord(letter) - ord('a') # here we matches to the words
            old_bucket = heads[letter_idx]
            heads[letter_idx] = []

            while old_bucket:
                curr = old_bucket.pop()
                next_letter = next(curr, None)
                if next_letter:
                    heads[ord(next_letter) - ord('a')].append(curr)
                else:
                    ans += 1
        return ans
