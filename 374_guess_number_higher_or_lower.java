/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lower = 1, upper = n;
        while (lower <= upper) {
            int ans = lower + (upper - lower) / 2;
            int res = guess(ans);
            if (res == -1) {
                upper = ans - 1;
            } else if (res == 1) {
                lower = ans + 1;
            } else {
                return ans;
            }
        }
        return 1;
    }
}
