class Solution:
    def minDominoRotations(self, tops: List[int], bottoms: List[int]) -> int:
        unique = set(tops).union(set(bottoms))
        shown = {}
        for n in unique:
            shown[n] = 0
        numbers_across_all = []
        combined = zip(tops, bottoms)
        for (up, down) in combined:
            if up != down:
                shown[up] += 1
                shown[down] += 1
            else:
                shown[up] += 1

        for key, value in shown.items():
            if value == len(tops):
                numbers_across_all.append(key)

        if not numbers_across_all: return -1

        res = []
        for cand in numbers_across_all:
            # print('cand', cand)
            # determine how many steps to take to become this cand in top
            count_flip_with_bottom = 0
            for num in tops:
                if cand != num: count_flip_with_bottom += 1
            # print('count_flip_with_bottom', count_flip_with_bottom)
            # determine how many steps to take to become this cand in bottom
            count_flip_with_top = 0
            for num in bottoms:
                if cand != num: count_flip_with_top += 1
            # print('count_flip_with_top', count_flip_with_top)
            res.append(min(count_flip_with_bottom, count_flip_with_top))
        # print('res', res)
        return min(res)

