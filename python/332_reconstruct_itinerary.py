from heapq import heappop, heappush
from collections import defaultdict

class Solution:
    def findItinerary(self, tickets: List[List[str]]) -> List[str]:
        # do need to set up graph with indexes
        # use adjacent list is faster with map
        travel_map = collections.defaultdict(list)
        for departure, arrival in tickets:
            # use heap to ensure lexical order
            heappush(travel_map[departure], arrival)
        res = []

        def dfs(departure):
            while travel_map[departure]:
                arrival = heappop(travel_map[departure])
                dfs(arrival)
            res.append(departure)
        dfs('JFK')
        return res[::-1]
