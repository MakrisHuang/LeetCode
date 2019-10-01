class Solution:
    """
    We take [0,2], because it has maximum ends time between the clips ([0,2],[0,1]) whose starts are smaller or equal to start (which is 0 by now). set start=2 end time of the selected clip([0,2])
    Now we take [1,9], since it has maximum ends time (9) between the clips whose starts are smaller or equal to start (which is 2 by now). set start=9
    Finally, we take [8,10] with the same reason above.
    Result is 3.

    Time Complexity: O(n)
    """
    def videoStitching(self, clips: List[List[int]], T: int) -> int:
        cnt = 0
        start = 0
        while start < T:
            max = -1
            exist = False
            for clip in clips:
                if clip[0] <= start and clip[1] > start and max < clip[1]:
                    max = clip[1]
                    exist = True
            if not exist:
                return -1
            start = max
            cnt += 1    # since overlapping clip exist, increase count
        return cnt
