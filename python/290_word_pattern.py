class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        words = str.split(" ")
        # put string to set and compare them
        # zip(pattern, words) is to check if they are matched aligned
        return len(pattern) == len(words) and len(set(zip(pattern, words))) == len(set(pattern)) == len(set(words))
