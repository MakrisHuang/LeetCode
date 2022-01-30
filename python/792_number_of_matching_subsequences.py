class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        head = [[] for _ in range(26)]
        for word in words:
            it = iter(word)
            head[ord(next(it)) - ord('a')].append(it)

        ans = 0
        for letter in s:
            index = ord(letter) - ord('a')
            old_bucket = head[index]
            head[index] = []

            while old_bucket:
                curr_iterator = old_bucket.pop()
                next_letter = next(curr_iterator, None)
                if next_letter:
                    head[ord(next_letter) - ord('a')].append(curr_iterator)
                else:
                    ans += 1
        return ans
