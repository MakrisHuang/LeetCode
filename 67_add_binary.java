class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aIdx = a.length() - 1, bIdx = b.length() - 1, carry = 0;
        while (aIdx >= 0 || bIdx >= 0) {
            int sum = carry;
            if (aIdx >= 0) sum += a.charAt(aIdx--) - '0';
            if (bIdx >= 0) sum += b.charAt(bIdx--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}