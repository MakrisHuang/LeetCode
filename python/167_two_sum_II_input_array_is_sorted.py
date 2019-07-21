class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        seen = {}
        for i, val in enumerate(numbers):
            if target - val in seen:
                return [seen[target - val], i + 1]
            seen[val] = i + 1
