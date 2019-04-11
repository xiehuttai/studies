package leetcode.hard.mid_array;

/**
 * 要求时间复杂度log（m+n），任然要优化
 */
public class Main {

    public static void main(String[] args) {

        //2
        int[] array_1_1= {1,2};
        int[] array_1_2= {3};

        // 3+4/2=2.5
        int[] array_2_1= {1,2};
        int[] array_2_2= {3,4};

        double medianSortedArray1 = new Main().findMedianSortedArrays(array_1_1, array_1_2);
        double medianSortedArrays2 = new Main().findMedianSortedArrays(array_2_1, array_2_2);

        System.out.println();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        double result =0.0;

        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;

        if (length==0)
            return result;

        int[] all = new int[length];

        int i=0;
        int j=0;
        int k=0;
        while (j<length1 && k<length2){
            if (nums1[j]<nums2[k]){
                all[i]=nums1[j];
                j++;
            } else {
               all[i]=nums2[k];
               k++;
            }
            i++;
        }
        while (j<length1){
            all[i]=nums1[j];
            i++;
            j++;
        }

        while (k<length2){
            all[i]=nums2[k];
            i++;
            k++;
        }

        if (length%2==0)
            result = (all[length / 2] + all[length / 2 - 1]) / 2.0;

        if (length%2==1)
            result = all[length/2]/1.0;

        return result;
    }


}