class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
            }
            else if (s.charAt(idx) == '[') {
                resStack.push(res);
                res = "";
                idx++;
            }
            else if (s.charAt(idx) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
            }
            else {
                res += s.charAt(idx++);
            }
        }
        return res;
    }
//         StringBuilder res = new StringBuilder();
//         Stack<String> strStack = new Stack<>();
//         Stack<Integer> countStack = new Stack<>();

//         int curr = 0;
//         String num = "";
//         String alph = "";
//         while (curr < s.length()) {
//             char c = s.charAt(curr);
//             if (Character.isDigit(c)) {
//                 if (alph.length() != 0) {
//                     strStack.push(new String(alph));
//                     // System.out.println("###push to strStack: " + alph);
//                     alph = "";
//                 }
//                 num += c;
//             } else if (c == '[') {
//                 // System.out.println("push to countSt: " + num);
//                 countStack.push(Integer.valueOf(new String(num)));
//                 num = "";
//             } else if (Character.isLetter(c)) {
//                 if (strStack.size() == 0 && countStack.size() == 0) {
//                     res.append(c);
//                 } else {
//                     alph += c;
//                 }
//             } else if (c == ']') {
//                 // System.out.println("curr: " + curr);
//                 if (alph.length() != 0) {
//                     strStack.push(new String(alph));
//                     // System.out.println("----push to strStack: " + alph);
//                     alph = "";
//                 }
//                 while (strStack.size() > 1 && strStack.size() > countStack.size()) {
//                     String top = strStack.pop();
//                     String last = strStack.pop();
//                     strStack.push(last + top);
//                 }
//                 int count = countStack.pop();
//                 String str = strStack.pop();
//                 StringBuilder sb = new StringBuilder();
//                 for (int i = 1; i <= count; i++) {
//                     sb.append(str);
//                 }
//                 if (countStack.size() != 0) {
//                     // append to the top one on the stack
//                     if (strStack.size() != 0) {
//                         // System.out.println("@@@@push to strStack: " + strStack.peek() + sb.toString());
//                         strStack.push(strStack.pop() + sb.toString());
//                     } else {
//                         strStack.push(sb.toString());
//                     }
//                 } else {
//                     // nothing left, append to the answer
//                     res.append(sb.toString());
//                 }
//                 System.out.println("res: " + res.toString());
//             }
//             curr++;
//         }

//         return res.toString();
    // }
}
