class TwoSum:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.arr = []

    def add(self, number: int) -> None:
        """
        Add the number to an internal data structure..
        """
        self.arr.append(number)

    def find(self, value: int) -> bool:
        """
        Find if there exists any pair of numbers which sum is equal to the value.
        """
        visited = set()
        for i, ele in enumerate(self.arr):
            if value - ele in visited:
                return True
            visited.add(ele)
        return False


# Your TwoSum object will be instantiated and called as such:
# obj = TwoSum()
# obj.add(number)
# param_2 = obj.find(value)
