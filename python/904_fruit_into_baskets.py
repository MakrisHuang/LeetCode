class Solution:
    def totalFruit(self, tree: List[int]) -> int:
        # apply sliding window + map
        # 1. keep consume more fruit with existing type
        #    if having 3rd type fruit, remove last type
        #    and check if current length is maximum
        fruit_m = collections.defaultdict(int)
        left = right = 0
        res = 0
        while right < len(tree):
            fruit_m[tree[right]] += 1
            right += 1

            while left < len(tree) and len(fruit_m) > 2:
                fruit_l = tree[left]
                fruit_m[fruit_l] -= 1
                if fruit_m[fruit_l] == 0:
                    del fruit_m[fruit_l]
                left += 1

            res = max(res, right - left)
        return res
