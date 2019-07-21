class Solution:
    """
        Use sliding window to keep removing left character
        and adding new character on the right

        cbaebabacd
        ---             -> first
         ---            -> remove 'c', add 'e'
          ---           -> remove 'a', add 'b'

        Time Complexity: O(len(s))
        Space Complexity: (1)
    """
    def findAnagrams(self, s: str, p: str) -> List[int]:
        bucket_target = [0 for i in range(26)]
        for val in p:
            bucket_target[ord(val) - ord('a')] += 1

        bucket_curr = [0 for i in range(26)]
        res = []
        if len(p) > len(s):
            return res

        # initialization for first look up
        for val in s[:len(p)]:
            bucket_curr[ord(val) - ord('a')] += 1
        if bucket_curr == bucket_target:
            res.append(0)

        for index in range(1, len(s) - len(p) + 1):
            # remove left
            bucket_curr[ord(s[index - 1]) - ord('a')] -= 1

            # add right, be careful for the index
            right = index + len(p) - 1
            bucket_curr[ord(s[right]) - ord('a')] += 1

            if bucket_curr == bucket_target:
                res.append(index)

        return res
