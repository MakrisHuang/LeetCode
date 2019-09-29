class Solution:
    """
    apply greedy by comparing the last occurrence of an alphabet
    ex. "ababddge"
    {'a': 2, 'b': 3, 'd': 5, 'g': 6, 'e': 7}
    i 0 c a j 2
    i 1 c b j 3
    i 2 c a j 3
    i 3 c b j 3
    i 4 c d j 5
    i 5 c d j 5
    i 6 c g j 6
    i 7 c e j 7

    since the last time b occurs at index 3, we need to divide at this index
    and then start for next iteration

    Time Complexity: O(N)
    Space Complexity: O(N)
    """
    def partitionLabels(self, S):
        last = {c: i for i, c in enumerate(S)}
        print(last)
        end = anchor = 0
        ans = []
        for i, c in enumerate(S):
            end = max(end, last[c])
            print('i', i, 'c', c, 'j', end)
            if i == end:
                ans.append(i - anchor + 1)
                anchor = i + 1
        return ans

