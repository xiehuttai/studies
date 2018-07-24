package sort;


/**
 * 将只含有0 1 2 的数据排序，要求自能遍历一遍，o(1) 的空间复杂度
 */
public class Sort012 {

    public static void main(String[] args) {

        int[] array = {0, 1, 2, 0, 2, 2, 1, 1, 0, 0, 0, 2, 1};

        int px0 = 0;
        int p = 0;
        int px2 = array.length - 1;

        while (0 == array[px0]) ++px0;
        while (2 == array[px2]) --px2;

        p = px0;

        while (p <= px2) {
            if (array[p] == 0) {
                swap(array, p, px0);
                while (0 == array[px0])
                    ++px0;
                p = px0;
            }
            if (array[p] == 2) {
                swap(array, p, px2);
                if (array[p] == 0)
                    swap(array, p, px0);
                while (2 == array[px2])
                    --px2;
            }
            ++p;
        }

        for (int i : array) {
            System.out.println(i);
        }

    }


    public static void swap(int[] array, int p1, int p2) {
        int temp = array[p1];
        array[p1] = array[p2];
        array[p2] = temp;
    }

}
