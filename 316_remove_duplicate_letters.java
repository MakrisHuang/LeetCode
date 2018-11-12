class Solution {
    public String removeDuplicateLetters(String s) {
        // 1. record the last occurence index given each alphabet in the string
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indexMap.put(s.charAt(i), i);
        }
        
        // 2. init result array
        char[] result = new char[indexMap.size()];
        int begin = 0, end = findLastIndex(indexMap);
        
        // 3. search for the alphabet in the given range
        for (int i = 0; i < result.length; i++) {
            char minChar = 'z' + 1;
            for (int k = begin; k <= end; k++) {
                char c = s.charAt(k);
                if (indexMap.containsKey(c) && c < minChar) {
                    minChar = c;
                    
                    // update begin globally
                    begin = k + 1;
                }
            }
            
            result[i] = minChar;
            
            // remove the letter who appears
            indexMap.remove(minChar);
            
            // update end index
            if (s.charAt(end) == minChar) {
                end = findLastIndex(indexMap);   
            }
        }
        return new String(result);
    }
    
    private int findLastIndex(Map<Character, Integer> indexMap) {
        if (indexMap == null || indexMap.size() == 0) return -1;
        int minIdx = Integer.MAX_VALUE;
        for (int index: indexMap.values()) {
            minIdx = Math.min(minIdx, index);
        }
        return minIdx;
    }
}