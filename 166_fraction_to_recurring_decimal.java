class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) return "";

        StringBuilder fraction = new StringBuilder();
        if ((numerator < 0 ^ denominator < 0) && numerator != 0) {
            fraction.append("-");
        }
        // convert input to Long
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        fraction.append(String.valueOf(dividend / divisor));
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return fraction.toString();
        }

        // fractional part exists
        fraction.append(".");
        // key: quotient, value: the position
        Map<Long, Integer> numMap = new HashMap<>();
        while (remainder != 0) {
            if (numMap.containsKey(remainder)) {
                fraction.insert(numMap.get(remainder), "(");
                fraction.append(")");
                break;
            }
            numMap.put(remainder, fraction.length());
            remainder *= 10;
            fraction.append(String.valueOf(remainder / divisor));
            remainder %= divisor;
        }
        return fraction.toString();
    }
}
