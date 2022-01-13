class Solution:
    def canReorderDoubled(self, arr: List[int]) -> bool:
        """
        Need to construct the array like this
        [x, 2x, y, 2y, z, 2z]
        """
        count = collections.Counter(arr)
        for x in sorted(arr, key = abs):
            if count[x] == 0: continue  # the number with 0 occurrences may be used, skip it
            if count[2 * x] == 0: return False
            count[x] -= 1
            count[2 * x] -= 1

        return True

