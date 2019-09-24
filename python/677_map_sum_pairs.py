class Node:
    def __init__(self):
        self.next = dict()
        self.value = 0

class MapSum:

    def __init__(self):
        self.map = {}
        self.root = Node()

    # Time Complexity: O(len(key))
    # Space Complexity: O(number of inputs)
    def insert(self, key: str, val: int) -> None:
        delta = val - self.map.get(key, 0)
        print('delta', delta)
        self.map[key] = val
        curr = self.root
        for c in key:
            curr = curr.next.setdefault(c, Node())
            curr.value += delta
            print('curr.val', curr.value)
            print('curr.next', curr.next)
        print("------")

    def sum(self, prefix: str) -> int:
        curr = self.root
        for c in prefix:
            if c not in curr.next:
                return 0
            curr = curr.next[c]
        return curr.value


# Your MapSum object will be instantiated and called as such:
# obj = MapSum()
# obj.insert(key,val)
# param_2 = obj.sum(prefix)
