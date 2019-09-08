class Solution:
    def reverseWords(self, s: str) -> str:
        s = s[::-1]
        word_list = s.split()

        for i in range(len(word_list)):
            word_list[i] = word_list[i][::-1]

        return " ".join(word_list)
