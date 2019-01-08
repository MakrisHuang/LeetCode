class Solution {    
    /*
        given example: [1,2,3,4,5,6,7] and k = 3
        output: 
            1 2 3 1 5 6 7 
            1 2 3 1 5 6 4 
            1 2 7 1 5 6 4 
            1 2 7 1 5 3 4 
            1 6 7 1 5 3 4 
            1 6 7 1 2 3 4 
            5 6 7 1 2 3 4 
    */
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return;
        
        k %= nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int currIdx = start;
            int prev = nums[start];
            do {
                int nextIdx = (currIdx + k) % nums.length;
                // System.out.println("nextIdx: " + nextIdx);
                int temp = nums[nextIdx];
                nums[nextIdx] = prev;
                prev = temp;
                currIdx = nextIdx;
                // System.out.println("currIdx: " + currIdx);
                count++;
                print(nums);
            } while (start != currIdx);
        }
    }
    
    public void print(int[] nums){
        for (int val: nums) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}