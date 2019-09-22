class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def longestPalindrome(self, s: str) -> int:
        cand_map = dict(collections.Counter(s))
        print(cand_map)
        count = 0
        for key in cand_map.keys():
            value = cand_map[key]
            if value > 1:
                consumed = (value // 2) * 2
                count += consumed
                cand_map[key] = value - consumed

        for value in cand_map.values():
            if value == 1:
                count += 1
                break
        return count
