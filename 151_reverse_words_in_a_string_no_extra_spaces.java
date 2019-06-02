class Solution {
    public String reverseWords(String s) {
        if (s == null) return s;

        char[] arr = s.toCharArray();
        int n = arr.length;
        // 1. reverse the entire string
        reverse(arr, 0, n - 1);

        // 2. reverse single word
        reverseWords(arr, n);

        // clean up spaces
        String res = cleanSpaces(arr, n);
        return res;
    }

    void reverseWords(char[] a, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && a[i] == ' ') i++;  // skip spaces
            while (j < i || j < n && a[j] != ' ') j++;  // skip non spaces
            reverse(a, i, j - 1);
        }
    }

    private String cleanSpaces(char[] a, int n) {
        int i = 0, j = 0;

        while (j < n) {
            while (j < n && a[j] == ' ') j++;   // skip spaces
            while (j < n && a[j] != ' ') a[i++] = a[j++];   // copy non-spaces
            while (j < n && a[j] == ' ') j++;   // skip spaces
            if (j < n) a[i++] = ' ';            // keep one space
        }

        return new String(a).substring(0,i);
    }

    private void reverse(char[] a, int i, int j) {
        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}
