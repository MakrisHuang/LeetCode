class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        number_set = set()
        for i in range(len(nums)):
            # Since size of set is limited to k
            # if any duplicate number found
            # we can ensure that the distance of i,j
            # are within k
            if nums[i] in number_set:
                return True
            number_set.add(nums[i])
            if len(number_set) > k:
                number_set.remove(nums[i - k])
        return False
