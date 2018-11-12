class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magMap = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char c = magazine.charAt(i);
            magMap.put(c, magMap.getOrDefault(c, 0) + 1);
        }
        
        for (int j = 0; j < ransomNote.length(); j++) {
            char c = ransomNote.charAt(j);
            if (magMap.containsKey(c)) {
                int appearTimes = magMap.get(c);
                appearTimes--;
                if (appearTimes == 0) magMap.remove(c);
                else magMap.put(c, appearTimes);
            } else {
                return false;
            }
        }
        return true;
    }
}