class Solution {
//     public static Map<String, List<String>> map;
//     static {
//         map = new HashMap<>();
//         map.put("2", new ArrayList<String>(Arrays.asList("a", "b", "c")));
//         map.put("3", new ArrayList<String>(Arrays.asList("d", "e", "f")));
//         map.put("4", new ArrayList<String>(Arrays.asList("g", "h", "i")));
//         map.put("5", new ArrayList<String>(Arrays.asList("j", "k", "l")));
//         map.put("6", new ArrayList<String>(Arrays.asList("m", "n", "o")));
//         map.put("7", new ArrayList<String>(Arrays.asList("p", "q", "r", "s")));
//         map.put("8", new ArrayList<String>(Arrays.asList("t", "u", "v")));
//         map.put("9", new ArrayList<String>(Arrays.asList("w", "x", "y", "z")));
//     }

//     public List<String> letterCombinations(String digits) {
//         if (digits.length() == 0) return new ArrayList<>();
//         List<List<String>> alphs = generateAlphs(digits);
//         Integer total = 1;
//         for (List<String> content: alphs) {
//             total *= content.size();
//         }
//         List<List<String>> tempResult = new ArrayList<>();

//         backtrace(tempResult, total, new ArrayList<>(), alphs);
//         List<String> result = new ArrayList<>();
//         tempResult.forEach(
//             list -> {
//                 StringBuilder sb = new StringBuilder();
//                 list.forEach(
//                     alph -> sb.append(alph)
//                 );
//                 result.add(sb.toString());
//             }
//         );
//         return result;
//     }

//     private List<List<String>> generateAlphs(String digits){
//         List<List<String>> alphs = new ArrayList<>();
//         for (int i = 0; i < digits.length(); i++){
//             String character = String.valueOf(digits.charAt(i));
//             List<String> content = map.get(character);
//             alphs.add(content);
//         }
//         return alphs;
//     }

//     private void backtrace(List<List<String>> result, Integer total, List<String> tempList, List<List<String>> alphs){
//         int len = alphs.size();
//         if (tempList.size() == len) {
//             result.add(new ArrayList<>(tempList));
//         } else{
//             for (int i = tempList.size(); i < len && result.size() < total; i++){ // 選擇字母群組
//                 List<String> content = alphs.get(i);

//                 for (int j = 0; j < content.size(); j++){ // 選擇字母

//                     tempList.add(content.get(j));
//                     backtrace(result, total, tempList, alphs);
//                     tempList.remove(tempList.size() - 1);
//                 }
//             }
//         }
//     }

    public List<String> letterCombinations(String digits) {
        ArrayList<String> results = new ArrayList<String>();
        ArrayList<String> dummy = new ArrayList<String>();
        results.add("");
        if (digits.length() == 0) return dummy;
        Map<Character, String> Dial = new HashMap<Character, String>();
        Dial.put('2', "abc");
        Dial.put('3', "def");
        Dial.put('4', "ghi");
        Dial.put('5', "jkl");
        Dial.put('6', "mno");
        Dial.put('7', "pqrs");
        Dial.put('8', "tuv");
        Dial.put('9', "wxyz");

        for (int i = 0; i < digits.length(); i++) {
            for (String str : results) {
                String letters = Dial.get(digits.charAt(i));
                for (int j = 0; j < letters.length(); j++)
                    dummy.add(str + letters.charAt(j));
            }
            results = dummy;
            dummy = new ArrayList<String>();
        }
        return results;
    }
}
