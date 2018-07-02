class Solution {
    public boolean judgeCircle(String moves) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('R', 0);
        map.put('L', 0);
        map.put('U', 0);
        map.put('D', 0);

        for (int i = 0; i < moves.length(); i++) {
            int times = map.get(moves.charAt(i));
            map.put(moves.charAt(i), times + 1);
        }

        return (map.get('R').intValue() == map.get('L').intValue())
                && (map.get('U').intValue() == map.get('D').intValue());
    }
}
