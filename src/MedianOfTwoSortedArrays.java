
public class MedianOfTwoSortedArrays {

    // This works. Can be made more efficient by storing 
    // greatest 2 numbers until median length hits
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
           int i = 0, j = 0;
            int len = nums1.length + nums2.length;
            int[] newarray = new int[len];
            if(nums1.length == 0) {
                if(nums2.length%2 ==1) return nums2[len/2];
                else return (nums2[len/2]+nums2[(len-1)/2])/2.0;
            }

            if(nums2.length == 0) {
                if(nums1.length%2 ==1) return nums1[len/2];
                else return (nums1[len/2]+nums1[(len-1)/2])/2.0;
            }

            int k=0;
            while (i < nums1.length && j < nums2.length) {
                if(nums1[i]<nums2[j]) {
                    newarray[k] = nums1[i];
                    i++;k++;
                }
                else {
                    newarray[k] = nums2[j];
                    j++;k++;
                }
              
            }

            while (i < nums1.length) {
                 newarray[k] = nums1[i];
                    i++;k++;
            }

            while (j < nums2.length) {
                 newarray[k] = nums2[j];
                    j++;k++;
            }

            if(len%2 ==1) return newarray[len/2];
                else return  (newarray[len/2]+newarray[(len-1)/2])/2.0;
            
            
        }
    }



    public static void main(String[] args) {
        Solution s = new MedianOfTwoSortedArrays().new Solution();

        System.out.println("Answer should be 2 :" +
                s.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2}));
        System.out.println("Answer should be 2.5 :" +
        s.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }
}
