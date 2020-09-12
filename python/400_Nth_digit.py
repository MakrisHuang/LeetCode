class Solution:
    def findNthDigit(self, n: int) -> int:
        length = 1
        count = 9
        start = 1
        while n > length * count:
            n -= length * count
            length += 1
            count *= 10
            start *= 10
        """
        The reason why (n-1) is to keep the correct digits finally in number they correspond to. Eg: if we are trying to find the 192th digit, we know range from 1th digit to 9th digit belongs to numbers from 1 to 9 and range from 10th digit to 189th digit belongs to numbers from 10 to 99, right? So it is obvious that the next number should be 100 and the 192th digit should be the 3rd digit of 100(now n=3). OK, back to the code, if we do not minus 1 from n and then devide the len, the 192th digit would go to the next number which is 101.
        """
        start += (n - 1) // length
        s = str(start)
        return int(s[(n - 1) % length])



