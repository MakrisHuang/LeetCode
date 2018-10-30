class Solution {
    // time complexity: O(len of num), space complexity: O(len of num in character)
    private final String[] wordsInOnePlaces
        = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] wordsTenToNighteen
        = new String[] {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] wordsInTwoPlaces
        = new String[] {"Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] segmentWords = new String[] {"Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return wordsInOnePlaces[0];

        List<Integer> segments = getSegmentDigits(num);
        Stack<String> wordsStack = new Stack<>();
        int level = 0;
        for (int segNum: segments) {
            transformToStr(segNum, level, wordsStack);
            level++;
        }

        // pop every word out of stack and concat them
        StringBuffer sb = new StringBuffer();
        while (!wordsStack.empty()) {
            if (wordsStack.size() == 1) {
                sb.append(wordsStack.pop());
            } else {
                sb.append(wordsStack.pop() + " ");
            }
        }
        return sb.toString();
    }

    private void transformToStr(int val, int segLevel, Stack<String> st) {
        // push level word first
        // ex. 12, 345 -> when 12,000, push thousand
        if (val == 0) return;
        if (segLevel > 0 ) st.push(segmentWords[segLevel - 1]);

        if (0 < val && val < 10) {     // ex. 1, 5, 9
            st.push(wordsInOnePlaces[val]);
        } else if (10 <= val && val < 20) {  // ex. 10, 15, 19
            int idx = val - 10;
            st.push(wordsTenToNighteen[idx]);
        } else if (20 <= val && val < 100) { // ex 38, 60, 20, 99
            int onePlaceIdx = val % 10;
            if (onePlaceIdx != 0) st.push(wordsInOnePlaces[onePlaceIdx]);

            int twoPlaceIdx = val / 10;
            st.push(wordsInTwoPlaces[twoPlaceIdx - 1]);
        } else { // 100 <= val && val < 1000
            // step 1
            // ex. 167 -> handle 67
            int twoDigitsVal = val % 100;
            if (twoDigitsVal > 0) {
                this.transformToStr(twoDigitsVal, 0, st);
            }

            // step 2
            st.push("Hundred");

            // step 3
            // ex. 100, 439, 999
            int hundredIdx = val / 100;
            st.push(wordsInOnePlaces[hundredIdx]);
        }
    }

    // divide number to segments with 3-digits as a segment
    // ex. 12345 -> 12, 345
    private List<Integer> getSegmentDigits(int num) {
        List<Integer> segments = new ArrayList<>();
        while (num > 0) {
            segments.add(num % 1000);
            num = num / 1000;
        }
        return segments;
    }
}
