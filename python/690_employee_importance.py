"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        # build an map where the index is the id of the employee
        id2Empl = {}
        for e in employees:
            id2Empl[e.id] = e

        # apply dfs to traverse all subordinates and accumulate the importances
        visited = set()
        def dfs(emplId):
            if emplId in visited: return 0
            employee = id2Empl[emplId]
            res = employee.importance
            for subordinateId in employee.subordinates:
                res += dfs(subordinateId)
            return res

        ans = dfs(id)
        return ans
