class Solution:
    def numMatchingSubseq(self, s: str, words: List[str]) -> int:
        def ifMatch(s, w):
            s_len = len(s)
            w_len = len(w)
            if w_len > s_len: return False
            s_idx = w_idx = 0
            while w_idx < w_len:
                while s_idx < s_len and s[s_idx] != w[w_idx]:
                    s_idx += 1

                if s_idx == s_len:
                    break
                if s[s_idx] == w[w_idx]:
                    s_idx += 1
                    w_idx += 1
            if w_idx < w_len: return False
            else: return True

        count = 0
        words2Count = collections.Counter(words)
        for word, occur in words2Count.items():
            if ifMatch(s, word):
                count += occur
        return count

