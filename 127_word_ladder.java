class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Queue<String> q = new LinkedList<>();
       q.add(beginWord);
       q.add(null);

       HashSet<String> dict = new HashSet<>();
       for(String word : wordList) {
           dict.add(word);
       }

       HashSet<String> v = new HashSet<>();  // visited set for word in wordDict
       v.add(beginWord);

       if(!dict.contains(endWord))
           return 0;

       int level = 1;

       while (!q.isEmpty()) {
           String s = q.poll();
           if(s != null) {
               for(int i = 0; i < s.length(); i++) {
                   char[] chars = s.toCharArray();
                   for(char c = 'a'; c <= 'z'; c++) { // 針對每個字元做變化，查看有無符合 endWord
                                                      // ex. hit -> ait -> bit ... -> hat -> hbt ...
                       chars[i] = c;
                       String word = new String(chars);
                       if(word.equals(endWord))
                           return level + 1;
                       if(dict.contains(word) && !v.contains(word)) {
                           q.add(word);
                           v.add(word);
                       }
                   }
               }
           } else {
               level++;
               if(!q.isEmpty()) {
                   q.add(null);     // why add null here? dummy variable?
               }
           }
       }
       return 0;
   }
}
