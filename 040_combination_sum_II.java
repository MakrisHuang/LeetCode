class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(result, candidates, new ArrayList<>(), target, 0);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, int[] candidates, List<Integer> tempList, int remain, int start){
        if (remain < 0) return;
        else if(remain == 0) result.add(new ArrayList<>(tempList));
        else{
            for (int i = start; i < candidates.length; i++){
                if(i > start && candidates[i] == candidates[i-1]) continue; // skip duplicates
                tempList.add(candidates[i]);
                backtracking(result, candidates, tempList, remain - candidates[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}