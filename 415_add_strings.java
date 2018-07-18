class Solution {
    public String addStrings(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        int idx1 = len1 - 1, idx2 = len2 - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (idx1 >= 0 && idx2 >= 0) {
            int n1 = Integer.parseInt(String.valueOf(num1.charAt(idx1)));
            int n2 = Integer.parseInt(String.valueOf(num2.charAt(idx2)));
            int sum = n1 + n2 + carry;
            if (sum >= 10) {
                carry = sum / 10;
                sum %= 10;
            } else {
                carry = 0;
            }
            sb.insert(0, sum);
            idx1--;
            idx2--;
        }

        if (idx1 >= 0 && idx2 < 0) {
            while (idx1 >= 0) {
                int n = Integer.parseInt(String.valueOf(num1.charAt(idx1)));
                int sum = n + carry;
                if (sum >= 10) {
                    carry = sum / 10;
                    sum %= 10;
                } else { carry = 0; }
                sb.insert(0, sum);
                idx1--;
            }
        } else if (idx1 < 0 && idx2 >= 0) {
            while (idx2 >= 0) {
                int n = Integer.parseInt(String.valueOf(num2.charAt(idx2)));
                int sum = n + carry;
                if (sum >= 10) {
                    carry = sum / 10;
                    sum %= 10;
                } else { carry = 0; }
                sb.insert(0, sum);
                idx2--;
            }
        }
        if (carry > 0) {
            sb.insert(0, carry);
        }

        return sb.toString();
    }
}
