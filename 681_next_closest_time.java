class Solution {
    public String nextClosestTime(String time) {
        String[] times = time.split(":");
        String hr = times[0], min = times[1];
        Integer [] digits = new Integer [] {Character.getNumericValue(hr.charAt(0)), Character.getNumericValue(hr.charAt(1)), Character.getNumericValue(min.charAt(0)), Character.getNumericValue(min.charAt(1))};
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), digits);

        int minIdx = 0, minDiff = Integer.MAX_VALUE;
        int[] origTime = timeToArr(Arrays.asList(digits));
        for (int i = 0; i < result.size(); i++) {
            int[] candTime = timeToArr(result.get(i));
            if (isValidTime(candTime)) {
                int diff = timeDiff(candTime, origTime);
                if (diff <= 0) continue;
                if (diff < minDiff) {
                    minDiff = diff;
                    minIdx = i;
                }
            }
        }

        List<Integer> res = result.get(minIdx);
        StringBuilder sb = new StringBuilder();
        sb.append(res.get(0)).append(res.get(1)).append(":").append(res.get(2)).append(res.get(3));
        return sb.toString();
    }

    private boolean isValidTime(int[] time) {
        if (time[0] > 23 || time[1] > 59) return false;
        return true;
    }

    private int[] timeToArr(List<Integer> cand) {
        int[] time = new int[2];
        String hr = "" + cand.get(0) + cand.get(1);
        String min = "" + cand.get(2) + cand.get(3);
        time[0] = Integer.parseInt(hr);
        time[1] = Integer.parseInt(min);
        return time;
    }

    private int timeDiff(int[] time1, int[] orig) {
        int hrDiff = (time1[0] - orig[0]) * 60;
        int minDiff = time1[1] - orig[1];
        return hrDiff + minDiff;
    }

    private void permute(List<List<Integer>> result, List<Integer> temp, Integer[] digits) {
        if (temp.size() == digits.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < digits.length; i++) {
            temp.add(digits[i]);
            permute(result, temp, digits);
            temp.remove(temp.size() - 1);
        }
    }
}
