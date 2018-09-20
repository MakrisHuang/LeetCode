class Solution {
    public List<Integer> partitionLabels(String S) {
        // define sub problem: start from a letter, and join the remaining
        // ex. given abrjixb -> [a, b, r, j, i, x, b]
        // find the starting index and ending index for each character
        // ex. a: [0, 0], b: [1, 6], r: [2, 2], j: [3, 3], i: [4, 4], x: [5, 5]
        // since the starting index and ending index of b is not identical
        // create a part of b [1, 6]

        // if we have overlapping of each interval, then merge them to satisfy the requirement


        Set<Character> uniLetters = new HashSet<>();
        for (int i = 0; i < S.length(); i++) {
            uniLetters.add(S.charAt(i));
        }

        // create interval for each letter
        List<List<Integer>> intervals = new ArrayList<>();
        for (Character c: uniLetters) {
            int start = 0, end = S.length() - 1;
            while (S.charAt(start) != c) start++;
            while (S.charAt(end) != c) end--;
            List<Integer> interval = new ArrayList<>();
            interval.add(start);
            interval.add(end);
            intervals.add(interval);
        }

        intervals.sort((i1,i2)-> i1.get(0) - i2.get(0));

        List<List<Integer>> res = new ArrayList<>();

        Iterator<List<Integer>> it = intervals.iterator();
        List<Integer> cur = null;
        while (it.hasNext()) {
            if (cur == null) {
                cur = it.next();
            } else {
                List<Integer> iv = it.next();
                if (cur.get(1) >= iv.get(0)) {
                    cur.set(1, Math.max(cur.get(1), iv.get(1)));
                } else {
                    res.add(cur);
                    cur = iv;
                }
            }
        }
        if (null != cur) res.add(cur);

        List<Integer> result = new ArrayList<>();
        for (List<Integer> interval: res) {
            result.add(interval.get(1) - interval.get(0) + 1);
        }
        return result;
    }
}
