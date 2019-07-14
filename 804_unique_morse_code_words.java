class Solution {

    private List<String> morse  = new ArrayList<>(Arrays.asList(".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."));

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> res = new HashSet<>();
        for (String w: words) {
            StringBuilder sb = new StringBuilder();
            for (char c: w.toCharArray()) {
                sb.append(morse.get(c - 'a'));
            }
            res.add(sb.toString());
        }
        return res.size();
    }
}
