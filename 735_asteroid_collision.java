class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> s = new LinkedList<>(); // use LinkedList to simulate stack so that we don't need to reverse at end.
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0 || s.isEmpty() || s.getLast() < 0)
                s.add(a[i]);
            else if (s.getLast() <= -a[i])
                if (s.pollLast() < -a[i]) i--;
        }
        return s.stream().mapToInt(i->i).toArray();

//         List<Integer> asteroidList =
//             Arrays.stream(asteroids).boxed().collect(Collectors.toList());

//         while (true) {
//             int numAsteroids = asteroidList.size();
//             List<Integer> temp = new ArrayList<>();

//             for (int i = 0; i < numAsteroids; i++) {
//                 if (i + 1 < numAsteroids && asteroidList.get(i) > 0
//                     && asteroidList.get(i + 1) < 0) {
//                     int leftSize = asteroidList.get(i);
//                     int rightSize = Math.abs(asteroidList.get(i + 1));
//                     if (leftSize > rightSize) {
//                         temp.add(asteroidList.get(i));
//                     } else if (leftSize < rightSize){
//                         temp.add(asteroidList.get(i + 1));
//                     }
//                     i++;
//                 } else {
//                     temp.add(asteroidList.get(i));
//                 }
//             }

//             if (temp.size() == asteroidList.size()) {
//                 asteroidList = temp;
//                 break;
//             }
//             asteroidList = temp;
//         }
//         return asteroidList.stream().mapToInt(i->i).toArray();
    }
}
