class Vector2D:

    def __init__(self, v: List[List[int]]):
        def it():
            for line in v:
                for val in line:
                    self.size -= 1
                    yield val
        self.it = it()
        self.size = sum(len(line) for line in v)

    def next(self) -> int:
        return next(self.it)

    def hasNext(self) -> bool:
        return self.size > 0


# Your Vector2D object will be instantiated and called as such:
# obj = Vector2D(v)
# param_1 = obj.next()
# param_2 = obj.hasNext()
