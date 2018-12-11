class Solution {
    // apply greedy algorithm
    // every time append a new string (cols) to start index
    // if start index points ' ', which means we are in a segmentation of sentence
    // i.e. words in sentence can correctly fit in a row
    // if not, we go back from start index until we have a space

    // Time Complexity: O(rows + n)
    // Space Complexity: O(n)           given n characters in sentence
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int start = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            start += cols;
            if (s.charAt(start % l) == ' ') {
                start++;
            } else {
                // if cannot fix, truncate the previous characters
                // until we meet space again
                while (start > 0 && s.charAt((start-1) % l) != ' ') {
                    start--;
                }
            }
        }

        return start / s.length();

//         int totalChars = rows * cols;
//         int startIdx = 0;
//         int times = 0;
//         while (startIdx <= totalChars) {
//             int sentIdx = 0;
//             while (sentIdx < sentence.length && startIdx <= totalChars) {
//                 // cound remaing spaces is enought for next word
//                 System.out.println("word: " + sentence[sentIdx]);
//                 int remaining = cols - startIdx % cols;
//                 int wordLen = sentence[sentIdx].length();
//                 if (remaining > wordLen) {
//                     startIdx += wordLen;
//                     startIdx += (remaining == wordLen) ? 0 : 1;  // add space

//                     sentIdx++;
//                 } else {
//                     // move to a new line and check validation
//                     int currRows = (startIdx / cols) + 1;
//                     System.out.println("curr rows: " + currRows);
//                     if (currRows + 1 > rows) {  // cannot satisfy all sentences words
//                         break;
//                     } else {
//                         // move to a new line
//                         startIdx = currRows * cols;
//                     }
//                 }
//                 System.out.println("startIdx: " + startIdx);
//             }
//             if (startIdx <= totalChars) {
//                 times++;
//             }
//         }
//         return times;
    }
}
