package heapsort;

/**
 * 实现堆排序
 * 升序 - 大顶堆：arr[i] >= arr[2*i+1] && arr[i] >= arr[2*i+2]
 * 降序 - 小顶堆：arr[i] <= arr[2*i+1] && arr[i] <= arr[2*i+2]
 */
public class HeapSort {

    /**
     * 出堆加到尾部
     * @param array
     */
    public static void sort(int[] array) {
        int size = array.length;
        buildMinHeap(array);
        while (size != 0) {
            /* 交换堆顶和最后一个元素 */
            int lastIndex= --size;
            int tmp = array[0];
            array[0] = array[lastIndex];
            array[lastIndex] = tmp;

            /*将剩下的元素进行堆调整*/
            siftDown(array, 0, size);
        }
    }

    /**
     * 初始化堆，从第一个非叶子节点开始
     * @param array
     */
    private static void buildMinHeap(int[] array) {
        int size = array.length;
        int lastNoLeafIndex=size/2-1;
        for (int i = lastNoLeafIndex ; i >= 0; i--)
            siftDown(array, i, size);
    }

    /**
     * 小顶堆调整
     * @param array
     * @param index
     * @param size
     */
    private static void siftDown(int[] array, int index, int size) {
        int key = array[index];
        int lastNoLeafIndex=size/2-1;
        while (index <= lastNoLeafIndex) {
            int left =  index*2 + 1;
            int right = index*2 + 2;
            int minIndex = (right >= size || array[left] < array[right])
                    ? left : right;
            if (key <= array[minIndex])
                break;
            array[index] = array[minIndex];
            index = minIndex;
        }
        array[index] = key;
    }


    public static void main(String[] args) {

        int[] array={1,2,3,4,5,6,7,2,2,4,5,6,2,5,3};
        sort(array);
        for (int i:array) {
            System.out.println(i);
        }

    }

}
