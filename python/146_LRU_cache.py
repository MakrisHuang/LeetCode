class Node:
    def __init__(self, key: str, value: str):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = dict()

        self.head = Node(-1, -1)
        self.tail = Node(-1, -1)

        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        # if not in map, return -1
        if key not in self.map: return -1

        # key in map, move the node to the end of list
        curr = self.map[key]
        curr.prev.next = curr.next
        curr.next.prev = curr.prev

        self.moveToTail(curr)

        return curr.value

    def put(self, key: int, value: int) -> None:
        if self.get(key) != -1:
            self.map[key].value = value
            return

        if self.capacity == len(self.map):
            # evict the least used one in the head
            del self.map[self.head.next.key]
            self.head.next = self.head.next.next
            self.head.next.prev = self.head

        insert = Node(key, value)
        self.map[key] = insert
        self.moveToTail(insert)

    def moveToTail(self, curr: Node):
        curr.next = self.tail
        self.tail.prev.next = curr

        curr.prev = self.tail.prev
        self.tail.prev = curr

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
