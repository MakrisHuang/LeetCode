class Solution {
    // apply greedy algorithm
    // every time append a new string (cols) to start index
    // if start index points ' ', which means we are in a segmentation of sentence
    // i.e. words in sentence can correctly fit in a row
    // if not, we go back from start index until we have a space

    /*
        "abc de f abc de f abc de f ..."
         ^      ^     ^    ^      ^
         0      7     13   18     25


    "abc de f abc de f abc de f ..." // start=0
     012345                          // start=start+cols+adjustment=0+6+1=7 (1 space removed in screen string)
            012345                   // start=7+6+0=13
                  012345             // start=13+6-1=18 (1 space added)
                       012345        // start=18+6+1=25 (1 space added)
                              012345
    */

    // Time Complexity: O(rows + n)
    // Space Complexity: O(n)           given n characters in sentence
    public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int curr = 0, l = s.length();
        for (int i = 0; i < rows; i++) {
            // directly append a new row
            curr += cols;

            // If the next position is a space, then this line can fit all words
            if (s.charAt(curr % l) == ' ') {
                curr++;
            } else {
                // if cannot fix, truncate the previous characters
                // until we meet space again
                while (curr > 0 && s.charAt((curr-1) % l) != ' ') {
                    curr--;
                }
            }
        }

        return curr / s.length();
    }
}
