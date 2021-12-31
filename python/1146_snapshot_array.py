# reference: https://leetcode.com/problems/snapshot-array/discuss/350562/JavaPython-Binary-Search
import bisect

class SnapshotArray:

    def __init__(self, length: int):
        self.length = length
        self.arr = [[[-1, 0]] for _ in range(length)]  # index: [(snap_id, value)]
        self.snapid = -1

    def set(self, index: int, val: int) -> None:
        if self.arr[index][-1][0] != self.snapid:
            self.arr[index].append([self.snapid, val])
        else:
            # snap id is identical, just update the val
            self.arr[index][-1][1] = val

    def snap(self) -> int:
        self.snapid += 1
        return self.snapid

    def get(self, index: int, snap_id: int) -> int:
        i = bisect.bisect_left(self.arr[index], [snap_id - 1, 0])
        if i == len(self.arr[index]):
            return self.arr[index][i - 1][1]
        if snap_id == self.arr[index][i][0] + 1:
            return self.arr[index][i][1]
        else:
            return self.arr[index][i - 1][1]

# Your SnapshotArray object will be instantiated and called as such:
# obj = SnapshotArray(length)
# obj.set(index,val)
# param_2 = obj.snap()
# param_3 = obj.get(index,snap_id)
