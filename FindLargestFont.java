import java.util.List;

public class FindLargestFont {
    int width;
    int height;
    List<Integer> fonts;

    public FindLargestFont(int width, int height, List<Integer> fonts) {
        this.width = width;
        this.height = height;
        this.fonts = fonts;
    }

    public int getWidth(char c, int fontSize) {
        return 0;
    }

    public int getHeight (int fontSize) {
        return 0;
    }

    public int getLargestFitFont(String input) {
        if (input == null || input.length() == 0) {
            return fonts.get(fonts.size() - 1);
        }

        // apply binary search to get largest font size
        int left = 0, right = fonts.size() - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isFit(input, fonts.get(mid))) {
                // can fit, so choose larger font
                left = mid;
            } else {
                // cannot fit, so choose smaller font
                right = mid;
            }
        }
        // always use right font
        if (isFit(input, right)) {
            return right;
        }
        if (isFit(input, left)) {
            return left;
        }
        return -1;
    }

    public boolean isFit(String input, int fontSize) {
        int start = 0;
        int currHeight = 0, currWidth = 0;
        for (int i = 0; i < input.length(); i++) {
            // add spaces
            while (i < input.length() && input.charAt(i) == ' ') {
                int charSize = getWidth(' ', fontSize);
                if (currWidth + charSize > width) {
                    currHeight += getHeight(fontSize);
                    if (currHeight > height) {
                        return false;
                    }
                    // go to a new line with charSize as new width
                    currWidth = charSize;
                } else {
                    currWidth += charSize;
                }
            }

            // add word
            int wordLen = 0;
            while (i < input.length() && input.charAt(i) != ' ') {
                wordLen += getWidth(input.charAt(i), fontSize);
            }
            if (wordLen > width) {
                return false;
            }

            // if cannot fit in one line, move to a new line
            if (currWidth + wordLen > width) {
                currHeight += getHeight(fontSize);
                if (currHeight > height) {
                    return false;
                }
                currWidth = wordLen;
            } else {
                currWidth += wordLen;
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
