/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 0; i < n; i++) if (knows(celebrity, i)) celebrity = i;
        for (int j = 0; j < n; j++) {
            if (j == celebrity) continue;

            // if j does not know candidate or candidaet knows j, return -1
            if ( !knows(j, celebrity) || knows(celebrity, j)) return -1;
        }
        return celebrity;
    }
}
