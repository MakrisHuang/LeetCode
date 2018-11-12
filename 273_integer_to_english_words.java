class Solution {
    private static final String[] wordOneDigits = {"Zero", "One", "Two", "Three", "Four",
                                                   "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] wordTenToNineteen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", 
                                                    "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] wordTenTimes = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", 
                                                 "Eighty", "Ninety"};
    private static final String[] wordThreeDigits = {"Thousand", "Million", "Billion"};
    
    public String numberToWords(int num) {
        if (num == 0) return wordOneDigits[0];
        
        // make segment of the number
        List<Integer> segments = getSegments(num);
        Stack<String> wordStack = new Stack<>();
        int level = 0;
        for (int segNum: segments) {
            transformNumToWord(segNum, level++, wordStack);
        }
        
        // concate as string
        StringBuilder sb = new StringBuilder();
        while (! (wordStack.size() == 0)) {
            if (wordStack.size() == 1) {
                sb.append(wordStack.pop());
            } else {
                sb.append(wordStack.pop() + " ");
            }
        }
        return sb.toString();
    }
    
    private void transformNumToWord(int val, int level, Stack<String> stack) {
        if (val == 0) return;
        if (level > 0) {
            stack.push(wordThreeDigits[level - 1]);
        }
        
        if (0 < val && val < 10) {
            stack.push(wordOneDigits[val]);
        } else if (10 <= val && val < 20) {
            stack.push(wordTenToNineteen[val - 10]);
        } else if (20 <= val && val < 100) {
            int oneDigit = val % 10;
            if (oneDigit != 0) {
                stack.push(wordOneDigits[oneDigit]);
            }
            int secondDigit = val / 10;
            stack.push(wordTenTimes[secondDigit - 2]);
        } else if (100 <= val && val < 1000) {
            int twoDigits = val % 100;
            transformNumToWord(twoDigits, 0, stack);
            
            stack.push("Hundred");
            
            int thirdDigits = val / 100;
            stack.push(wordOneDigits[thirdDigits]);
        }
    }
    
    private List<Integer> getSegments(int num) {
        List<Integer> segments = new ArrayList<>();
        while (num > 0) {
            segments.add(num % 1000);
            num /= 1000;
        }
        return segments;
    }
}