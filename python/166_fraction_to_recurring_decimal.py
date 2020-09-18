class Solution:
    def fractionToDecimal(self, numerator: int, denominator: int) -> str:
        num, den = numerator, denominator
        if not den:  # denominator is 0
            return
        if not num:  # numerator is 0
            return "0"
        res = []
        if (num < 0) ^ (den < 0):
            res.append("-")  # add the sign
        num, den = abs(num), abs(den)
        res.append(str(num//den))
        rmd = num % den
        if rmd == 0:
            return "".join(res)  # only has integral part
        res.append(".")  # has frational part
        dic = {}
        while rmd:
            if rmd in dic:   # the remainder recurs and insert by the length of previous ans
                res.insert(dic[rmd], "(")
                res.append(")")
                break
            dic[rmd] = len(res)
            div, rmd = divmod(rmd * 10, den)
            res.append(str(div))
        return "".join(res)

