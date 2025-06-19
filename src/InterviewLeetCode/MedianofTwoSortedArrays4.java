package InterviewLeetCode;

public class MedianofTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        /**
         let' try using Binary Search.
         */
        //here we will always make sure that nums1 is smaller in lenght.
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int l = 0;
        int r = m;
        while(l<= r){
            int elementsPickedFrom1st = l + (r-l)/2;
            int elementsPickedFrom2nd = (m+n+1)/2 - elementsPickedFrom1st;

            //for the 1st half
            int a = (elementsPickedFrom1st == 0) ? Integer.MIN_VALUE:nums1[elementsPickedFrom1st-1];
            int b = (elementsPickedFrom2nd == 0) ? Integer.MIN_VALUE:nums2[elementsPickedFrom2nd-1];
            // for the 2nd half
            int c = (elementsPickedFrom1st == m) ? Integer.MAX_VALUE:nums1[elementsPickedFrom1st];
            int d = (elementsPickedFrom2nd == n) ? Integer.MAX_VALUE:nums2[elementsPickedFrom2nd];
            if(a<=d && b <= c){
                return (m+n)%2 !=0 ? Math.max(a,b): (Math.max(a,b) + Math.min(c,d))/2.0;
            } else if(a > d){
                r = elementsPickedFrom1st -1;
            }else{
                l = elementsPickedFrom1st +1;
            }
        }
        return -1;

        //return o1spaceApproch(nums1,nums2);
        //return naiveApproch(nums1, nums2);
    }

    private double o1spaceApproch(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int []newArray = new int[n];
        int ptr1 = 0;
        int ptr2 = 0;
        int idx1 = n/2;
        int idx2 = (n/2)-1;
        int idx1Value = 0;
        int idx2Value =0;
        int i = 0;
        while(ptr1 < nums1.length && ptr2 < nums2.length){
            if (nums1[ptr1] < nums2[ptr2]) {
                if(i == idx1){
                    idx1Value = nums1[ptr1];
                } else if(i == idx2){
                    idx2Value = nums1[ptr1];
                }
                ptr1++;
            } else {
                if(i == idx1){
                    idx1Value = nums2[ptr2];
                } else if(i == idx2){
                    idx2Value = nums2[ptr2];
                }
                ptr2++;
            }
            i++;
        }

        while(ptr2 < nums2.length){
            if(i == idx1){
                idx1Value = nums2[ptr2];
            } else if(i == idx2){
                idx2Value = nums2[ptr2];
            }
            ptr2++;
            i++;
        }

        while(ptr1< nums1.length){
            if(i == idx1){
                idx1Value = nums1[ptr1];
            } else if(i == idx2){
                idx2Value = nums1[ptr1];
            }
            ptr1++;
            i++;
        }
        return (n%2 == 0)?(double) ((double) idx1Value + (double) idx2Value)/2 : (double) idx1Value;
    }

    private double naiveApproch(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int []newArray = new int[n];
        int ptr1 = 0;
        int ptr2 = 0;
        for(int i = 0;i<n;i++){
            if(ptr1 < nums1.length && ptr2 < nums2.length) {
                if (nums1[ptr1] < nums2[ptr2]) {
                    newArray[i] = nums1[ptr1];
                    ptr1++;
                } else {
                    newArray[i] = nums2[ptr2];
                    ptr2++;
                }
                continue;
            }
            if(ptr1 >= nums1.length){
                while(i<n && ptr2 < nums2.length){
                    newArray[i] = nums2[ptr2];
                    ptr2++;
                    i++;
                }
            }else if(ptr2 >= nums2.length){
                while(i<n && ptr1< nums1.length){
                    newArray[i] = nums1[ptr1];
                    ptr1++;
                    i++;
                }
            }

        }
        return (n % 2 == 0) ? (double) ((double) newArray[(n / 2)] + (double) newArray[((n / 2) - 1)]) / 2 : (double) newArray[n / 2];
    }

    public static void main(String[] args) {
            MedianofTwoSortedArrays4 solution = new MedianofTwoSortedArrays4();

            int[] nums1 = {1, 3};
            int[] nums2 = {2};
            //System.out.println("Median: " + solution.findMedianSortedArrays(nums1, nums2)); // Output: 2.0

            int[] nums3 = {1, 2};
            int[] nums4 = {3, 4};
            System.out.println("Median: " + solution.findMedianSortedArrays(nums3, nums4)); // Output: 2.5

            int[] nums5 = {0, 0};
            int[] nums6 = {0, 0};
            System.out.println("Median: " + solution.findMedianSortedArrays(nums5, nums6)); // Output: 0.0

            int[] nums7 = {};
            int[] nums8 = {1};
            System.out.println("Median: " + solution.findMedianSortedArrays(nums7, nums8)); // Output: 1.0

            int[] nums9 = {2};
            int[] nums10 = {};
            System.out.println("Median: " + solution.findMedianSortedArrays(nums9, nums10)); // Output: 2.0
        }
}
