class Solution:
    """
    Time complexity : O(3 ^ N * 4 ^ M) (N = 2,3,4,5,6,8, M = 7,9)
 ) where N is the number of digits in the input that maps to 3 letters (e.g. 2, 3, 4, 5, 6, 8) and M is the number of digits in the input that maps to 4 letters (e.g. 7, 9), and N+M is the total number digits in the input.

    Space Complexity: O(3 ^ N * 4 ^ M)
    """
    def letterCombinations(self, digits: str) -> List[str]:
        mapping = {
            "2": ["a", "b", "c"],
            "3": ["d", "e", "f"],
            "4": ["g", "h", "i"],
            "5": ["j", "k", "l"],
            "6": ["m", "n", "o"],
            "7": ["p", "q", "r", "s"],
            "8": ["t", "u", "v"],
            "9": ["w", "x", "y", "z"]
        }

        def backtrace(res: List[str], temp: List[str], digits: str, curr_digit: int, mapping: dict):
            if curr_digit == len(digits):
                res.append("".join(temp))
            else:
                digit = digits[curr_digit]
                # get limit of available chars:
                # ex. digit = 4 => length = 3, range = [0,1,2]
                for i in range(len(mapping[digit])):
                    temp.append(mapping[digit][i])
                    backtrace(res, temp, digits, curr_digit + 1, mapping)
                    temp.pop()

        res = []
        if not digits: return res
        backtrace(res, [], digits, 0, mapping)
        return res
