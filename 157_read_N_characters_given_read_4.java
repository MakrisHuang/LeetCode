/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int sum = 0, count = 0;
        while ((count < n) && (sum = read4(Arrays.copyOfRange(buf, count, buf.length))) > 0) {
            count += sum;
        }
        return (count > n) ? n : count;
    }
}