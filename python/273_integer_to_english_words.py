class Solution:
    def __init__(self):
        self.oneDigits = ["Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"]
        self.tenToNineteen = ["Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"]
        self.tenTimes = ["Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        self.levels = ["Thousand", "Million", "Billion"]

    def transform(self, val: int, stack: List[str], level: int):
        if val == 0:
            return
        if level > 0:
            stack.append(self.levels[level - 1])

        if 0 < val < 10:
            stack.append(self.oneDigits[val])
        elif 10 <= val < 20:
            stack.append(self.tenToNineteen[val % 10])
        elif 20 <= val < 100:
            first = val % 10
            if first != 0:
                stack.append(self.oneDigits[first])
            second = val // 10
            stack.append(self.tenTimes[second - 2])
        elif 100 <= val < 1000:
            twoDigits = val % 100
            self.transform(twoDigits, stack, 0)

            stack.append("Hundred")

            thirdDigit = val // 100
            stack.append(self.oneDigits[thirdDigit])

    def getSegment(self, num: int) -> List[int]:
        segments = []
        while num > 0:
            segments.append(num % 1000)
            num //= 1000
        return segments

    def numberToWords(self, num: int) -> str:
        if num == 0:
            return self.oneDigits[num]

        # split words per 3 characters
        stack = []
        level = 0
        segments = self.getSegment(num)
        for seg in segments:
            self.transform(seg, stack, level)
            level += 1

        stack.reverse()
        return " ".join(stack)
