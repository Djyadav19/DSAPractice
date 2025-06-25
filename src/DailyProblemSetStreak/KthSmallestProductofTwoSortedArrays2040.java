package DailyProblemSetStreak;

public class KthSmallestProductofTwoSortedArrays2040 {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -1_000_000_000_0L;  // -1e10
        long right = 1_000_000_000_0L;  // 1e10
        long result = 0;

        while (left <= right) {
            long midProduct = left + (right - left) / 2;
            long count = countLessEqual(nums1, nums2, midProduct);

            if (count >= k) {
                result = midProduct;
                right = midProduct - 1;
            } else {
                left = midProduct + 1;
            }
        }

        return result;
    }

    private long countLessEqual(int[] nums1, int[] nums2, long midProduct) {
        long count = 0;

        for (int a : nums1) {
            if (a > 0) {
                // Find rightmost index where a * nums2[i] <= mid
                int l = 0, r = nums2.length - 1, pos = -1;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long)a * nums2[m] <= midProduct) {
                        pos = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += (pos + 1);
            } else if (a < 0) {
                // Find leftmost index where a * nums2[i] <= mid
                int l = 0, r = nums2.length - 1, pos = nums2.length;
                while (l <= r) {
                    int m = l + (r - l) / 2;
                    if ((long)a * nums2[m] <= midProduct) {
                        pos = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += (nums2.length - pos);
            } else { // a == 0
                if (midProduct >= 0) count += nums2.length;
            }
        }

        return count;
    }

    public static void main(String[] args) {
            KthSmallestProductofTwoSortedArrays2040 solver = new KthSmallestProductofTwoSortedArrays2040();
            int[] nums1 = {-4, -2, 0, 3};
            int[] nums2 = {2, 4};
            long k = 4;
            long result = solver.kthSmallestProduct(nums1, nums2, k);
            System.out.println("The " + k + "th smallest product is: " + result);
        }
}
