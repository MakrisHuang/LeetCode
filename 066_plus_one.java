class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> result = new ArrayList<>();
        for (int i: digits) result.add(i);

        for (int i = result.size() - 1; i >= 0; i--){
            int digit = result.get(i);
            if (digit < 9){
                result.set(i, digit + 1);
                break;
            }else{
                result.set(i, 0);
            }
        }
        if (result.get(0) == 0){
            result.add(0);
            result.set(0, 1);
        }

        int[] list = new int[result.size()];
        for (int i = 0; i < result.size(); i++) list[i] = result.get(i);
        return list;
    }
}
