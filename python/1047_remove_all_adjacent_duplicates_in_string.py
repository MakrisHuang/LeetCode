class Solution:
    def removeDuplicates(self, S: str) -> str:
        st = []
        for c in S:
            if st and st[-1] == c:
                st.pop()
            else:
                st.append(c)
        return "".join(st)
