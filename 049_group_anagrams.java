class Solution {
    // count the occurence times of each alphabet
    // Time Complexity: O(N * K) where N = # of strs and K = longest length of a str
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) return null;
        Map<String, List<String>> anagramMap = new HashMap<>();
        int[] count = new int[26];
        for (String str: strs) {
            Arrays.fill(count, 0);
            for (int i = 0; i < str.length(); i++) count[str.charAt(i) - 'a']++;
            
            // create key by string builder
            StringBuilder sb = new StringBuilder();
            String delimiter = "#";
            for (int times: count) {
                sb.append(times);
                sb.append(delimiter);
            }
            String key = sb.toString();
            if (! anagramMap.containsKey(key)) {
                anagramMap.put(key, new ArrayList<>());
            }
            List<String> anagramList = anagramMap.get(key);
            anagramList.add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
    
    // sort each string
    // Time Complexity: O(N KlogK) where N = # of str, and K is the longest length of a string
    // public List<List<String>> groupAnagrams(String[] strs) {
    //     if (strs == null) return null;
    //     Map<String, List<String>> anagramMap = new HashMap<>();
    //     for (String word: strs) {
    //         char[] charArr = word.toCharArray();
    //         Arrays.sort(charArr);
    //         String sortedStr = new String(charArr);
    //         if (!anagramMap.containsKey(sortedStr)) {
    //             anagramMap.put(sortedStr, new ArrayList<>());
    //         }
    //         anagramMap.get(sortedStr).add(word);
    //     }
    //     return new ArrayList<>(anagramMap.values());
    // }
}