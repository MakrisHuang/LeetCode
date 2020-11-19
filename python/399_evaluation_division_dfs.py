class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        index = 0
        cand = dict()
        for equ in equations:
            if equ[0] not in cand:
                cand[equ[0]] = index
                index += 1
            if equ[1] not in cand:
                cand[equ[1]] = index
                index += 1
        N = len(cand)
        metric = [[0] * N for i in range(N)]

        # put number in metric
        for index, equ in enumerate(equations):
            first_idx = cand.get(equ[0])
            second_idx = cand.get(equ[1])
            metric[first_idx][second_idx] = values[index]
            metric[second_idx][first_idx] = 1 / values[index]

        # apply dfs search to find answer
        res = [-1] * len(queries)
        for i, query in enumerate(queries):
            first_idx = cand.get(query[0])
            second_idx = cand.get(query[1])

            if first_idx == None or second_idx == None:
                continue

            if metric[first_idx][second_idx] != 0:
                res[i] = metric[first_idx][second_idx]
                continue

            if metric[second_idx][first_idx] != 0:
                res[i] = metric[second_idx][first_idx]
                continue
            res[i] = self.dfs(metric, first_idx, second_idx)

        return res

    def dfs(self, metric: List[List[float]], start: int, end: int) -> float:
        stack = []
        stack.append(start)

        val_stack = [1.0]
        visited = [False] * len(metric)

        while len(stack) > 0:
            curr_idx = stack.pop()
            curr_val = val_stack.pop()

            if visited[curr_idx]:
                continue
            visited[curr_idx] = True

            if curr_idx == end:
                return curr_val

            for i in range(len(metric)):
                if metric[curr_idx][i] != 0:
                    stack.append(i)
                    val_stack.append(curr_val * metric[curr_idx][i])

        return -1


