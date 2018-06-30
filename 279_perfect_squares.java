class Solution {
    public int numSquares(int n) {
        if(n == 0) return 0;
        List<Integer> perfectSquares = new LinkedList<>();
        int current = 1;
        int square = 1;

				//build the set of perfect squares we have to work with
        while((square = current * current) <= n){
            perfectSquares.add(square);
            current++;
        }

        int[] solutions = new int[n+1];
        solutions[0] = 0;
        for(int i = 1; i < solutions.length; i++) {
            int solution = i; //worst case is 1+1+1+1...
            for(Integer perfectSquare : perfectSquares) {
                if(perfectSquare > i) break; //avoid index out of bounds
                solution = Math.min(solution, solutions[i - perfectSquare] + 1);
            }
            solutions[i] = solution;
        }
        return solutions[n];
    }
}
