class HitCounter:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.count_map = collections.defaultdict(int)

    def update(self, timestamp: int) -> None:
        deleted = []
        for t, hits in self.count_map.items():
            # discard larger than 5 mins
            if timestamp - t >= 300:
                deleted.append(t)
        for key in deleted: del self.count_map[key]

    def hit(self, timestamp: int) -> None:
        """
        Record a hit.
        @param timestamp - The current timestamp (in seconds granularity).
        """
        self.update(timestamp)
        self.count_map[timestamp] += 1

    def getHits(self, timestamp: int) -> int:
        """
        Return the number of hits in the past 5 minutes.
        @param timestamp - The current timestamp (in seconds granularity).
        """
        self.update(timestamp)
        total = 0
        for val in self.count_map.values():
            total += val
        return total


# Your HitCounter object will be instantiated and called as such:
# obj = HitCounter()
# obj.hit(timestamp)
# param_2 = obj.getHits(timestamp)
