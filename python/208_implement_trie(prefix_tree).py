class Node:
    def __init__(self):
        self.next = [None for _ in range(26)]
        self.string = None

class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = Node()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        curr = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not curr.next[index]:
                curr.next[index] = Node()
            curr = curr.next[index]
        curr.string = word

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        curr = self.root
        for c in word:
            index = ord(c) - ord('a')
            if not curr.next[index]:
                return False
            curr = curr.next[index]
        return curr.string and curr.string == word

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        curr = self.root
        for c in prefix:
            index = ord(c) - ord('a')
            if not curr.next[index]:
                return False
            curr = curr.next[index]
        return True

# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
