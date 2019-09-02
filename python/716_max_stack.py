class MaxStack(list):
    def push(self, x):
        m = x
        if self:
            m = max(m, self[-1][1])
        self.append((x, m))

    def pop(self):
        return list.pop(self)[0]

    def top(self):
        return self[-1][0]

    def peekMax(self):
        return self[-1][1]

    def popMax(self):
        m = self[-1][1]
        b = []
        while self[-1][0] != m:
            b.append(self.pop())
        self.pop()
        b.reverse()
        for ele in b:
            self.push(ele)
        return m
