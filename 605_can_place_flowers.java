class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        List<Integer> bed = Arrays.stream(flowerbed)
                                  .boxed()
                                  .collect(Collectors.toList());
        bed.add(0, 0); // push at head
        bed.add(0); // push at last
        for (int i = 1; i < bed.size() - 1; i++) {
            if (bed.get(i - 1) + bed.get(i) + bed.get(i + 1) == 0) {
                n--;
                i++;
            }
        }
        return n <= 0;
    }
}
