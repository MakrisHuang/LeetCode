class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        counter = dict(collections.Counter(text))
        if 'l' in counter:
            counter['l'] //= 2
        if 'o' in counter:
            counter['o'] //= 2
        keys = set(['b','a','l','o','n'])
        vals = [value for key, value in counter.items() if key in keys]
        if len(vals) != 5:
            return 0
        return min(vals) if vals else 0

