class Solution:
    def shortestDistance(self, words: List[str], word1: str, word2: str) -> int:
        dist = len(words)
        i = 0
        curr = -1
        while i < len(words):
            if words[i] == word1 or words[i] == word2:
                if curr == -1 or words[i] == words[curr]:
                    curr = i
                elif words[i] != words[curr]:   # curr could be word1 or word2, and i is the opposite
                    dist = min(dist, i - curr)
                    curr = i
            i += 1
        return dist
