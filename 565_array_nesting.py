class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(n)
    def arrayNesting(self, nums: List[int]) -> int:
        # find out all combination
        parent = [-1 for _ in range(len(nums))]
        # value in the index represents the parent set
        for i, num in enumerate(nums):
            if parent[i] == -1:
                # set curr as parent
                parent[i] = curr_parent = i
                next_idx = nums[i]
                while parent[next_idx] != curr_parent:
                    parent[next_idx] = curr_parent
                    next_idx = nums[next_idx]

        parent_count = dict(collections.Counter(parent))
        return max(parent_count.values())

