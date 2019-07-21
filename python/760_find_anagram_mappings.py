class Solution:
    def anagramMappings(self, A: List[int], B: List[int]) -> List[int]:
        index_map = dict((key, index) for index,key in enumerate(B))
        return [index_map[key] for key in A]

