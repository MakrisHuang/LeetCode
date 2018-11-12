class Solution {
    public String countAndSay(int n) {
        String prev = "1";
        if (n == 1) return prev;
            
        String res = "";
        for (int i = 2; i <= n; i++) {
            int currIdx = 0;
            res = "";
            while (currIdx < prev.length()) {
                char currNumChar = prev.charAt(currIdx);
                int count = 1;
                while (currIdx + 1 < prev.length() 
                       && prev.charAt(currIdx) == prev.charAt(currIdx + 1)) {
                    count++;
                    currIdx++;
                }
                currIdx++;
                String countAndNum = String.valueOf(count) + String.valueOf(currNumChar);
                res += countAndNum;
            }
            prev = res;
        }
        return res;
    }
}