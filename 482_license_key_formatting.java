class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder();
        for (int i = S.length() - 1; i >= 0; i--)
            if (S.charAt(i) != '-')
                sb.append(sb.length() % (K + 1) == K ? '-' : "").append(S.charAt(i));
        return sb.reverse().toString().toUpperCase();

        // below codes will not work!!!!!!!!!!!
//         S = S.replace("-", "");

//         int idx = S.length() - 1;
//         String result = "";
//         while (idx >= 0 && idx + 1 >= K) {
//             String group = S.substring(idx - K + 1, idx + 1);
//             result = group.toUpperCase() + result;

//             idx -= K;
//             if (idx >= 0) {
//                 result = "-" + result;
//             }
//         }

//         // append remaining to front
//         result = S.substring(0, idx + 1).toUpperCase() + result;
//         return result;
    }
}
