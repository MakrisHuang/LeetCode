public class MagicDictionary {
    // Time Complexity: O(Sigma( len(Word_i) ^ 2) ) in building dictionary;
    //                  O(len(searchWord)) in search
    Set<String> words;
    Map<String, Integer> count;

    public MagicDictionary() {
        words = new HashSet();
        count = new HashMap();
    }

    private ArrayList<String> generalizedNeighbors(String word) {
        ArrayList<String> ans = new ArrayList();
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            char letter = ca[i];
            ca[i] = '*';
            String magic = new String(ca);
            ans.add(magic);
            ca[i] = letter;
        }
        return ans;
    }

    public void buildDict(String[] words) {
        for (String word: words) {
            this.words.add(word);
            for (String nei: generalizedNeighbors(word)) {
                count.put(nei, count.getOrDefault(nei, 0) + 1);
            }
        }
    }

    public boolean search(String word) {
        for (String nei: generalizedNeighbors(word)) {
            int c = count.getOrDefault(nei, 0);
            if (c > 1 || c == 1 && !words.contains(word)) return true;
        }
        return false;
    }
}
// class MagicDictionary {

//     String[] dict;
//     /** Initialize your data structure here. */
//     public MagicDictionary() {

//     }

//     /** Build a dictionary through a list of words */
//     public void buildDict(String[] dict) {
//         this.dict = dict;
//     }

//     /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
//     public boolean search(String word) {
//         int wordLen = word.length();
//         for (String cand: this.dict) {
//             if (cand.length() == wordLen) {
//                 // count differences
//                 int count = 0;
//                 for (int i = 0; i < wordLen; i++) {
//                     if (cand.charAt(i) != word.charAt(i)) {
//                         count++;
//                     }
//                 }
//                 if (count == 1) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dict);
 * boolean param_2 = obj.search(word);
 */
