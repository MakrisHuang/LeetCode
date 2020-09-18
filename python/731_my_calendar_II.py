class MyCalendarTwo:

    def __init__(self):
        self.first = []
        # only store the overlapped part, we don't need to store booked part in first array
        self.overlapping = []

    def book(self, start: int, end: int) -> bool:
        for o_start, o_end in self.overlapping:
            if start < o_end and end > o_start:
                return False
        for f_start, f_end in self.first:
            if start < f_end and end > f_start:
                self.overlapping.append((max(start, f_start), min(end, f_end)))
        self.first.append((start, end))
        return True

# Your MyCalendarTwo object will be instantiated and called as such:
# obj = MyCalendarTwo()
# param_1 = obj.book(start,end)
