class Solution {
    // Time Complexity: O(len(start))
    public boolean canTransform(String start, String end) {
        if (!start.replace("X", "").equals(end.replace("X", ""))) return false;
        
        int p1 = 0, p2 = 0;
        while (p1 < start.length() && p2 < end.length()) {
            while (p1 < start.length() && start.charAt(p1) == 'X') p1++;
            while (p2 < end.length() && end.charAt(p2) == 'X') p2++;
            
            //if both of the pointers reach the end the strings are transformable
            if (p1 == start.length() && p2 == end.length()) return true;
            // if only one of the pointer reach the end they are not transformable
            if (p1 == start.length() || p2 == end.length()) return false;
            
            if (start.charAt(p1) != end.charAt(p2)) {
                return false;
            }
            
            if (start.charAt(p1) == 'R' && p1 > p2) {
                return false;
            }
            if (start.charAt(p1) == 'L' && p2 > p1) {
                return false;
            }
            p1++;
            p2++;
        }
        return true;
    }
//     public boolean canTransform(String start, String end) {
//         if (start.length() != end.length()) return false;
//         if (start.length() == 1 && end.length() == 1 && ! start.equals(end)) return false;
//         int curr = 0, len = start.length();
//         while (curr + 1 < len) {
//             String sub1 = start.substring(curr, curr + 2);
//             String sub2 = end.substring(curr, curr + 2);
//             if (sub1 != sub2) {
//                 if (! canChange(sub1, sub2)) {
//                     // may not able to exchange, compare current char
//                     if (start.charAt(curr) != end.charAt(curr)) return false;
//                     curr++;
//                 }
//             }
//             if (curr == len - 1 && start.charAt(curr) != end.charAt(curr)) return false;
//             curr += 2;
//         }
//         return true;
//     }
    
//     public boolean canChange(String from, String to) {
//         if ((from.equals("RX") && to.equals("XR")) || (from.equals("XL") && to.equals("LX"))) return true;
//         return false;
//     }
}