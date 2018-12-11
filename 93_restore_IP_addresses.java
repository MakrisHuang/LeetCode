class Solution {
    // time complexity: O(C(n, 4)), Space Complexity: O(C(n, 4)) * 4
    // 4 is the number of IP segments we have
    public List<String> restoreIpAddresses(String s) {
        int[] cand = new int [] {1, 2, 3};
        List<String> res = new ArrayList<>();
        backtrace(res, new ArrayList<>(), cand, s.length(), s);
        return res;
    }

    public void backtrace(List<String> res, List<Integer> temp, int[] cand, int remain, String s) {
        if(temp.size() == 4 && remain == 0){
            String ip = getIpAddress(temp, s);
            if(!ip.equals("-1")){
                res.add(ip);
                return;
            }
        }

        if(temp.size() == 4 || remain < 0){
            return;
        }

        for (int i = 0; i < cand.length; i++) {
            temp.add(cand[i]);
            backtrace(res, temp, cand, remain - cand[i], s);
            temp.remove(temp.size() - 1);
        }
    }

    public String getIpAddress(List<Integer> ranges, String s) {
        String res = "";
        int start = 0;
        for (int i = 0; i < 4; i++) {
            String si = s.substring(start, start + ranges.get(i));
            start += ranges.get(i);
            if(Integer.valueOf(si) > 255) {
                return "-1";
            }
            if(ranges.get(i) > 1 && si.charAt(0) == '0') {
                return "-1";
            }
            if(i < 3) res += si+".";
            else res+= si;
        }
        return res;
    }
}
