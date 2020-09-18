class Solution:
    def readBinaryWatch(self, num: int) -> List[str]:
        res = []
        nums1 = [8, 4, 2, 1]
        nums2 = [32, 16, 8, 4, 2, 1]
        for i in range(num + 1):
            hour_list, min_list = [], []
            self.generateDigits(nums1, i, 0, 0, hour_list)
            self.generateDigits(nums2, num - i, 0, 0, min_list)
            for hour in hour_list:
                if hour >= 12: continue
                for minute in min_list:
                    if minute >= 60: continue
                    formatted_min = "0{}".format(minute) if minute < 10 else str(minute)
                    res.append(str(hour) + ":" + formatted_min)
        return res

    def generateDigits(self, nums: List[int], count: int, pos: int, sum: int, res: List[int]):
        if count == 0:
            res.append(sum)
            return
        for i in range(pos, len(nums)):
            self.generateDigits(nums, count - 1, i + 1, sum + nums[i], res)
