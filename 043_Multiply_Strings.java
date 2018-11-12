class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int [m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int p : pos) {
            if(!(sb.length() == 0 && p == 0))   // skip leading 0
                sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();

//         if (num1.equals("0") || num2.equals("0")) return "0";
//         int len1 = num1.length();
//         int len2 = num2.length();
//         int[] int1 = new int[len1];
//         int[] int2 = new int[len2];
//         int max = 300;

//         for (int i = 0; i < len1; i++){
//             int1[len1 - i - 1] = num1.charAt(i) - '0';
//         }
//         for (int j = 0; j < len2; j++){
//             int2[len2 - j - 1] = num2.charAt(j) - '0';
//         }

//         int[] resultInt = new int[max];
//         for (int m = 0; m < len1; m++){
//             for (int n = 0; n < len2; n++){
//                 resultInt[m + n] += int1[m] * int2[n];
//             }
//         }

//         for (int carry = 0, i = 0; i < max; i++){
//             resultInt[i] += carry;
//             carry = resultInt[i] / 10;
//             resultInt[i] %= 10;
//         }

//         String resultStr = "";
//         for (int i = 0; i < max; i++){
//             resultStr = resultInt[i] + resultStr;
//         }

//         for (int j = 0; j < max; j++){
//             if (resultStr.charAt(j) != '0'){
//                 resultStr = resultStr.substring(j);
//                 break;
//             }
//         }
//         return resultStr;
    }
}
