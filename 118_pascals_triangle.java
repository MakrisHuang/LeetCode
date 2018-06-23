class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>(numRows);
        if (numRows <= 0) return result;

        // initialization
        result.add(0, new ArrayList<>(Arrays.asList(1)));
        if (numRows == 1) return result;

        result.add(1, new ArrayList<>(Arrays.asList(1, 1)));
        if (numRows == 2) return result;

        for (int layerIdx = 2; layerIdx < numRows; layerIdx++) {
            int numOfEle = layerIdx + 1;

            List<Integer> layer = new ArrayList<>(numOfEle);
            layer.add(0, 1);

            List<Integer> prevLayer = result.get(layerIdx - 1);
            for (int i = 1; i < numOfEle - 1; i++) {
                layer.add(i, prevLayer.get(i - 1) + prevLayer.get(i));
            }
            layer.add(numOfEle - 1, 1);

            result.add(layerIdx, layer);
        }

        return result;
    }
}
