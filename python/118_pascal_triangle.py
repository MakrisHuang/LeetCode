class Solution:
    def generate(self, numRows: int) -> List[List[int]]:
        if numRows == 0:
            return []
        elif numRows == 1:
            return [[1]]
        else:
            res = [[1]]
            for i in range(1, numRows):
                new_row = [1]

                last_row = res[i - 1]
                for inner in range(0, len(last_row) - 1):
                    new_row.append(last_row[inner] + last_row[inner + 1])
                new_row.append(1)

                res.append(new_row)
            return res

