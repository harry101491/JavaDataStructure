
public class MedianTwoArrays {

    public static double findMedianSortedArrays(int[] a1, int[] a2) {
        int i = 0;
        int j = 0;
        int k = 0;
        int m = a1.length;
        int n = a2.length;
        int med1 = -1, med2 = -1;

        while (k <= (m + n) / 2) {
            med2 = med1;
            if (i < m && j < n) {
                med1 = Math.min(a1[i++], a2[j++]);
            } else if (i < n) {
                med1 = a1[i++];
            } else {
                med1 = a2[j++];
            }
            k++;
        }
        if ((m + n) % 2 != 0) {
            return med1;
        } else {
            return (med1 + med2) / 2;
        }
    }

    public static void main(String args[]) {
        int nums1[] = { 1, 2 };
        int nums2[] = { 3, 4 };

        System.out.print(findMedianSortedArrays(nums1, nums2));
    }
}
