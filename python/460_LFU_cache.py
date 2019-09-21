class Node:
    def __init__(self, key, val):
        self.key = key
        self.val = val
        self.freq = 1
        self.prev = self.next = None

class DLinkedList:
    def __init__(self):
        self._sentinel = Node(None, None)
        self._sentinel.next = self._sentinel.prev = self._sentinel
        self._size = 0

    def __len__(self):
        return self._size

    def append(self, node):
        node.next = self._sentinel.next
        node.prev = self._sentinel
        node.next.prev = node
        self._sentinel.next = node
        self._size += 1

    def pop(self, node=None):
        # pop element from the tail of the linked list
        if self._size == 0:
            return
        if not node:
            node = self._sentinel.prev

        node.prev.next = node.next
        node.next.prev = node.prev
        self._size -= 1

        return node

class LFUCache:

    def __init__(self, capacity: int):
        # initialize two map: ndoe and frequency

        # key: int, value: Node
        self.node_map = dict()

        # key: freq (int), value: DLinkedList for node
        self.freq_map = collections.defaultdict(DLinkedList)

        self._size = 0
        self._capacity = capacity
        self._minfreq = 0

    def update(self, node):
        freq = node.freq

        self.freq_map[freq].pop(node)

        # why min freq?
        if self._minfreq == freq and not self.freq_map[freq]:
            self._minfreq += 1

        node.freq += 1
        freq = node.freq
        self.freq_map[freq].append(node)

    def get(self, key: int) -> int:
        if key not in self.node_map:
            return -1

        node = self.node_map[key]
        # add frequency to move to head
        self.update(node)
        return node.val

    # evict: for the minfreq, go to the linked list
    # and find out the `head` of that node and remove it
    def put(self, key: int, value: int) -> None:
        if self._capacity == 0:
            return

        if key in self.node_map:
            node = self.node_map[key]
            self.update(node)
            node.val = value
        else:
            if self._size == self._capacity:
                # evict least frequency one
                node = self.freq_map[self._minfreq].pop()
                del self.node_map[node.key]
                self._size -= 1

            node = Node(key, value)
            self.node_map[key] = node
            self.freq_map[1].append(node)
            self._minfreq = 1
            self._size += 1

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
