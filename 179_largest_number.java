class Solution {
    class MyComp implements Comparator<String> {
        public int compare(String a, String b) {
            String s1 = a + b;
            String s2 = b + a;
            return s2.compareTo(s1);
        }
    }

    public String largestNumber(int[] nums) {
        if (nums.length == 0) return "";

        String[] values = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            values[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(values, new MyComp());
        if (values[0].equals("0")) return "0";
        StringBuilder sb = new StringBuilder();
        for (String str: values){
            sb.append(str);
        }
        return sb.toString();
    }
}
