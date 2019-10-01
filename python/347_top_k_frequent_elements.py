class Solution:
    # Time Complexity: O(NlogK)
    # Space Complexity: O(N)
    def topKFrequent_heap(self, nums: List[int], k: int) -> List[int]:
        count_map = collections.Counter(nums)
        q = []
        for key, value in count_map.items():
            heapq.heappush(q, (-value, key))
        res = []
        while k > 0:
            res.append(heapq.heappop(q)[1])
            k -= 1
        return res

    # Time Complexity: O(N)
    # Space Complexity: O(N)
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        bucket = [[] for _ in range(len(nums) + 1)]
        count_map = dict(collections.Counter(nums))
        for key, freq in count_map.items():
            bucket[freq].append(key)

        pos = len(nums)
        res = []
        while pos >= 0 and k > 0:
            if bucket[pos]:
                res += bucket[pos]
                k -= len(bucket[pos])
            pos -= 1
        return res

