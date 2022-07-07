class Solution:
    def longestSubstring_divideAndConquer(self, s: str, k: int) -> int:
        # use divide and conquer.
        def recursive(s: str, start: int, end: int, k: int) -> int:
            if end < k: return 0
            count = [0] * 26
            for i in range(start, end):
                count[ord(s[i]) - ord('a')] += 1
            for mid in range(start, end):
                if count[ord(s[mid]) - ord('a')] >= k: continue
                midNext = mid + 1
                # invalid characters cannot be used even though we include all invalid characters
                # for example, we have 2 * d, but k=3, so we will keep skipping character d
                while midNext < end and count[ord(s[midNext]) - ord('a')] < k:
                    midNext += 1
                return max(recursive(s, start, mid, k), recursive(s, midNext, end, k))
            # if end == start, then actually we just return the length of the substring
            return end - start

        return recursive(s, 0, len(s), k)

    # Overall time complexity: O(N)
    def longestSubstring(self, s: str, k: int) -> int:

        # function time complexity: O(N)
        # function space complexity: O(26) = O(1)
        def longest_distinct(s, k, num_distinct_chars):
            begin = end = 0
            max_len = num_unique = num_no_less_k = 0
            d = collections.defaultdict(int)
            while end < len(s):
                end_c = s[end]
                d[end_c] += 1
                if d[end_c] == 1:
                    num_unique += 1
                if d[end_c] == k:
                    num_no_less_k += 1
                end += 1
                while num_unique > num_distinct_chars:
                    begin_c = s[begin]
                    if d[begin_c] == 1:
                        num_unique -= 1
                    if d[begin_c] == k:
                        num_no_less_k -= 1
                    d[begin_c] -= 1
                    begin += 1
                if num_unique == num_no_less_k:
                    max_len = max(max_len, end - begin)
            return max_len

        if not s: return 0
        max_len = 0
        for num_distinct_chars in range(1, 26 + 1):
            max_len = max(max_len, longest_distinct(s, k, num_distinct_chars))
        return max_len

