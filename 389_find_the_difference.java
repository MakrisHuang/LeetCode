class Solution {
    public char findTheDifference(String s, String t) {
        // use XOR
        String st = s+t;
        char res = 0;
        for(char c : st.toCharArray()){
            res^=c;
        }
        return res;
//         Map<Character, Integer> map = new HashMap<>();
//         for (int i = 0; i < s.length(); i++) {
//             char sc = s.charAt(i);
//             if (map.containsKey(sc)) {
//                 map.put(sc, map.get(sc) + 1);
//             } else {
//                 map.put(sc, 1);
//             }
//         }

//         for (int j = 0; j < t.length(); j++) {
//             char tc = t.charAt(j);
//             if (map.containsKey(tc)) {
//                 map.put(tc, map.get(tc) - 1);
//             } else {
//                 map.put(tc, 1);
//             }
//         }

//         char add = '0';
//         for (Map.Entry<Character, Integer> entry: map.entrySet()) {
//             if (entry.getValue() != 0) add = entry.getKey();
//         }
//         return add;
    }
}
