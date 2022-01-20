# class Solution:
#     def wordsTyping(self, sentence: List[str], R: int, C: int) -> int:
#         times = 0
#         start = 0
#         # loop that check total chars to fit
#         word_idx = 0
#         row = 1
#         col = 0
#         while row <= R and col <= C:
#             print("word_idx", word_idx)
#             # check if we can fit a line
#             letterCount = len(sentence[word_idx])
#             last = word_idx + 1
#             while last < len(sentence):
#                 if col + len(sentence[last]) + letterCount + 1 > C: break
#                 letterCount += (1 + len(sentence[last]))
#                 last += 1
#             print("last", last)
#             # case 1: ran out all words in a single line
#             # start to appending new sentence
#             if last == len(sentence) and letterCount <= C:
#                 print("run out all words")
#                 times += 1
#                 start = 0
#                 col += letterCount
#                 print("col", col)
#                 if C - col <= 1:    # no enough space in the line, move to next one
#                     row += 1
#                     col = 0
#                 continue

#             # case 2: a single line cannot fit all words
#             if last < len(sentence):
#                 print("move to next line: ", str(row + 1))
#                 # move to next line
#                 row += 1
#                 word_idx = last
#         return times

#         return times

"""
what he's trying to do in this algorithm is try to build an equivalence of the original problem that is easier to tackle:
so, what we intend to do, for example as below, is to modify the displayed repeated string without changing the position of each letter on the screen.

so, we change this:
i_had
apple
pie_i
had__
apple

into something like:
i_had_
apple_
pie_i_
had_
apple_

now, if you wrap all rows of the second screen, it would be a repeated pattern of 'i_had_apple_pie_', there's an 'underscore' between every two words, plus another underscore after the last word in the string. Now it's much easier to figure out how many 'i_had_apple_pie_' displayed by applying some integer division technique, as we can track the length of this modified string. Again, the reason that this is equivalent to original screen is because we haven't change any letter's position on the original screen.

The only problem left is how to build the mapping between the old screen and the new screen. To better describe the process, it's easier to just use numbers:
in this example, row width is 5, positions are numbered as [0,1,2,3,4], imagine there's a pointer starting at 0, also image the position of pixels of the new screen is a 1D list instead of 2D matrix.

i_had_ 0+4+1+1 = 6
apple_ 6+4+1+1 =12
pie_i_ 12+4+1+1 = 18
had_ 18+4-1+1= 22
apple_ 22+4+1+1 = 28

1, at first row:
0 is the starting position, +4 moves the pointer to the end of the row on the original screen. The end of the row is 'd', which is the end of the word 'had', according to the mapping rule we made, we do '+1' to add a 'underscore', and then another +1 to move the pointer to next position, which is the start of the next row). The new position of the pointer in the mask screen then is 6.
2, second row:
6 is the new starting position in the new screen, as calculated from previous step. Repeat the same process.
3, third row:
12 is the new starting position, as calculated from previous step. Repeat the same process.
4, fourth row:
18 is the new starting position, as calculated from previous step. Now when we +4 we have a problem, as the end of row 'a', is middle of a word 'apple'. if we look at the original screen, this position now should be replaced by an 'underscore'. According to our rule, we should hide the underscore. The way we hide it is simply do '-1' to take the pointer back one position, which makes the end of row one and only one 'underscore'. Then another +1 to move the pointer to next position, which is the start of the next row)
...

we keep doing this if we have more rows. so that we have a pointer that always points to the beginning of a new row, which is always equal to last position+1 of the growing string of repeated pattern 'i_had_apple_pie_', which is also equal to the length of the growing string.

To conclude my thought: I believe this is a workable solution, yet it's not a clean one. When you try to tweak a solution like this to work, sometimes you would have to deal with unforeseen edge cases, it's ok for an excise at home, but it can easily fail you in an interview.
"""

# https://leetcode.com/problems/sentence-screen-fitting/discuss/90869/Python-with-explanation
class Solution:
    def wordsTyping(self, sentence: List[str], rows: int, cols: int) -> int:
        s = ' '.join(sentence) + ' '
        sentence_ptr = 0
        for i in range(rows):
            sentence_ptr += cols - 1
            # case 1: sentence_ptr at the end of screen falls exactly on the space
            if s[sentence_ptr % len(s)] == ' ':
                sentence_ptr += 1
            # case 2: sentence_ptr at the end of screen coincides with the last letter of a word (next is space)
            elif s[(sentence_ptr + 1) % len(s)] == ' ':
                sentence_ptr += 2
            else:
                # case 3: sentence_ptr at the end of screen falls in the middle of a word; roll back
                while sentence_ptr > 0 and s[(sentence_ptr - 1)% len(s)] != ' ':
                    sentence_ptr -= 1
        return sentence_ptr // len(s)
