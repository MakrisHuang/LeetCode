class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        for (int age: ages) count[age]++;

        int aToB = 0;
        for (int i = 0; i < count.length; i++) {
            int ageA = i;
            for (int j = 0; j < count.length; j++) {
                int ageB = j;
                if ((ageA * 0.5 + 7 >= ageB) || ageA < ageB || (ageA < 100 && ageB > 100)) {
                    continue;
                }
                aToB += (count[ageA] * count[ageB]);
                if (ageA == ageB) {
                    aToB -= count[ageA];
                }
            }
        }
        return aToB;
    }
}
