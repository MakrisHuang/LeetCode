class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count_map = collections.Counter(nums)
        return heapq.nlargest(k, count_map.keys(), key=count_map.get)
