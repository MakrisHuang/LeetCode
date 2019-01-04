public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return res;
        }
        backtrace(res, "", num, target, 0, 0, 0);
        return res;
    }

     /** Apply backtrace algorithm to evaluate all possible solutions
     *
     * @param res           output list
     * @param path          current string result
     * @param num           source number in string format
     * @param target        target number
     * @param position      current index (position) in source number
     * @param eval          value we calculated so far
     *                      use this variable to prevent evaluate expression at the end
     *                      ex. 1 + 3 + 5 => we calculate 1 + 3 on the fly, then keep going
     * @param multed        previous multiplication number
     *                      to do * before +/-, we need to store this value as needed
     */
    public void backtrace(List<String> res, String path, String num,
                          int target, int position, long eval, long multed) {
        // check we meet the end of the string
        if (position == num.length()) {
            if (target == eval) {   // check result equals to target
                res.add(path);
            }
            return;
        }

        for (int i = position; i < num.length(); i++) {
            // if i == position, we have one digit of number
            // and one digit of '0' is allowed
            // but if i is after position, and if we have '0' at the beginning
            // this is not allowed ex. 00, 05
            if (i != position && num.charAt(position) == '0') {
                break;
            }

            // get current value
            long curr = Long.parseLong(num.substring(position, i + 1));

            if (position == 0) {    // we cannot add any operator before the head of our string number
                backtrace(res, path + curr, num, target, i + 1, curr, curr);
            } else {                // here we add operator between numbers
                // + operator
                backtrace(res, path + "+" + curr, num, target, i + 1, eval + curr, curr);

                // - operator
                backtrace(res, path + "-" + curr, num, target, i + 1, eval - curr, -curr);

                // * operator
                // the reason why use eval - multed + multed * curr
                // is because we add curr when doing +, or subtract curr when doing -
                // so we need to subtract it first
                backtrace(res, path + "*" + curr, num, target, i + 1, eval - multed + multed * curr,
                    multed * curr);
            }
        }
    }
}
