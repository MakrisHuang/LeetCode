class RandomizedSet:
    import random
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.map = dict()
        self.list = list()

    def insert(self, val: int) -> bool:
        """
        Inserts a value to the set. Returns true if the set did not already contain the specified element.
        """
        if val not in self.map:
            self.map[val] = len(self.list)
            self.list.append(val)
            return True
        else:
            return False

    def remove(self, val: int) -> bool:
        """
        Removes a value from the set. Returns true if the set contained the specified element.
        """
        if val in self.map:
            val_idx = self.map[val]

            last_ele = self.list[-1]
            last_idx = self.map[last_ele]

            self.map[val] = last_idx
            self.list[last_idx] = val

            self.list[val_idx] = last_ele
            self.map[last_ele] = val_idx

            self.list[:] = self.list[:-1]
            del self.map[val]

            return True
        else:
            return False

    def getRandom(self) -> int:
        """
        Get a random element from the set.
        """
        return self.list[random.randrange(len(self.list))]

# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()
