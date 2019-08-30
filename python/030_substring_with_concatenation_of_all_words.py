class Solution:
    def findSubstring(self, s: str, words: List[str]) -> List[int]:
        res = []
        if not words:
            return res
        from collections import defaultdict, Counter

        all_word_map = dict(Counter(words))

        word_len = len(words[0])
        word_nums = len(words)

        begin = 0
        # find at each position
        for i in range(len(s) - word_len * word_nums + 1):
            curr_word_map = defaultdict(int)
            word_count = 0
            while word_count < word_nums:
                sub = s[i + word_count * word_len: i + (word_count + 1) * word_len]
                if sub in all_word_map:
                    curr_word_map[sub] += 1
                    if curr_word_map[sub] > all_word_map[sub]:
                        break
                else:
                    break
                word_count += 1

            if word_count == word_nums:
                res.append(i)

        return res





