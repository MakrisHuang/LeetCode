class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         int index = m + n - 1;
//         m = (m > 0) ? m - 1 : m;
//         n--;
//         System.out.println("begin");
//         System.out.println("m = " + m);
//         System.out.println("n = " + n);

//         while (n >= 0 && m >= 0){
//             if (nums2[n] > nums1[m]){
//                 nums1[index--] = nums2[n--];
//             }else{
//                 nums1[index--] = nums1[m--];
//             }
//             System.out.println("after updated");
//             System.out.println("m = " + m);
//             System.out.println("n = " + n);
//         }
//     }

     public void merge(int[] nums1, int m, int[] nums2, int n) {
		 int t;
	      for(int i=0;i<n;i++)
	    	  nums1[m+i]=nums2[i];
	      for(int i=0;i<m+n;i++) {
	    	  for(int j=0;j<m+n-i-1;j++) {
	    		  if(nums1[j+1]<nums1[j]) {
	    			  t=nums1[j+1];
	    			  nums1[j+1]=nums1[j];
	    			  nums1[j]=t;
	    		  }
	    	  }
	      }
     }
}
