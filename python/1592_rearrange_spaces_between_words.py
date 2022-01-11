class Solution:
    def reorderSpaces(self, text: str) -> str:
        words = text.split()
        num_intervals = len(words) - 1  # ex. 4
        num_spaces = 0                  # ex. 9
        for ch in text:
            if ch == " ":
                num_spaces += 1
        extra_spaces = num_spaces % num_intervals if num_intervals > 0 else num_spaces  # ex. 9 % 4 = 1
        spaces_in_interval = num_spaces // num_intervals if num_intervals > 0 else num_spaces # 9 / 4 = 2
        spaces_text = spaces_in_interval * " "
        res = spaces_text.join(words)
        res += extra_spaces * " "
        return res
