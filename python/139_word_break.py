class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        from collections import deque
        word_set = set(wordDict)
        queue = deque()
        queue.append(0)

        visited = [False] * len(s)

        while len(queue) > 0:
            start = queue.popleft()
            if not visited[start]:
                for end in range(start + 1, len(s) + 1):
                    if s[start:end] in word_set:
                        queue.append(end)
                        if end == len(s): return True
                visited[start] = True
        return False

    def wordBreak_dp(self, s: str, wordDict: List[str]) -> bool:
        word_set = set(wordDict)
        dp = [False] * (len(s) + 1)
        dp[0] = True

        for i in range(0, len(s) + 1):
            for j in range(0, i):
                if dp[j] and s[j:i] in word_set:
                    dp[i] = True
                    break

        return dp[len(s)]
