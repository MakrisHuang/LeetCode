class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return new String();
        String common = strs[0];
        for(String word: strs) {
            while(common.length() > 0) {
                if(word.startsWith(common))
                    break;
                else {
                    common = common.substring(0, common.length() - 1);
                }
            }
        }
        return common;
    }
}
