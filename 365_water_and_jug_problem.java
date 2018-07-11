class Solution {
    public boolean canMeasureWater(int x, int y, int z) {
        //limit brought by the statement that water is finallly in one or both buckets
        if(x + y < z) return false;
        //case x or y is zero
        if( x == z || y == z || x + y == z ) return true;

        //get GCD, then we can use the property of Bézout's identity
        return z%GCD(x, y) == 0;
    }

    public int GCD(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

//     public boolean canMeasureWater(int x, int y, int z) {
//         if (x + y == z) return true;

//         // as the mathematical formula, find mx + ny = z
//         // one jug must has smaller volume than z
//         int max = Math.max(x, y);
//         if (max < z) return false;

//         // where x and y must be relatively prime
//         int min = Math.min(x, y);
//         for (int i = 2; i <= Math.sqrt(min) + 1; i++) {
//             if (x % i == 0 && y % i == 0) {
//                 System.out.println("find gcd: " + i);
//                 return false;
//             }
//         }

//         // find possible (m, n) to satisfy the equation
//         Map<Integer, Boolean> visited = new HashMap<>();
//         int remaining = max, empty = 0;
//         while (true) {
//             if (visited.containsKey(remaining)) break;
//             else {
//                 visited.put(remaining, true);
//             }

//             if (remaining == z) return true;
//             remaining = remaining - min;
//             System.out.println("remaining: " + remaining);
//             if (remaining == z) return true;

//             if (remaining > min) continue;
//             else {
//                 empty = min - remaining;
//                 System.out.println("empty: " + empty);

//                 remaining = max - empty;
//                 System.out.println("max - empty: " + remaining);
//             }
//         }

//         return false;
//     }
}
