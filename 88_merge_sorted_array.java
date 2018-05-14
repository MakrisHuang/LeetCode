class Solution {
     public void merge(int[] nums1, int m, int[] nums2, int n) {
		int temp;
	    for(int i = 0; i < n; i++)  // copy num2 to num1
            nums1[m+i]=nums2[i];
        for(int i=0;i < m + n; i++) {   // sort by making comparsion
            for(int j = 0;j < m + n - i - 1; j++) {
                if(nums1[j + 1] < nums1[j]) {
                    temp=nums1[j + 1];
                    nums1[j + 1]=nums1[j];
                    nums1[j]=temp;
                }
            }
        }
    }
}
