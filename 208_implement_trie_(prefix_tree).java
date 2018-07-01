class Trie {
    private final int SIZE = 26;

    class Node {
        char c;
        Node[] childs;
        boolean isFound;

        Node(char c) {
            this.c = c;
            this.childs = new Node[SIZE];
            this.isFound = false;
        }
        Node() {
            this.childs = new Node[SIZE];
            this.isFound = false;
        }
    }

    Node root;

    private Node createTrieNode(char c) {
        Node node = new Node(c);
        return node;
    }

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr = this.root;
        Node prev = null;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int idx = c - 'a';
            if (curr.childs[idx] == null) {
                curr.childs[idx] = createTrieNode(c);
            }
            curr = curr.childs[idx];
        }
        curr.isFound = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node curr = this.root;
        int charIdx = 0;
        for (int i = 0; i < word.length() && curr != null; i++) {
            char c = word.charAt(i);
            curr = curr.childs[c - 'a'];
        }
        return curr != null && curr.isFound;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node curr = this.root;
        int charIdx = 0;
        for (int i = 0; i < prefix.length() && curr != null; i++) {
            char c = prefix.charAt(i);
            curr = curr.childs[c - 'a'];
        }
        return curr != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
