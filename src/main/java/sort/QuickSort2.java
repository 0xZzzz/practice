package sort;

import java.util.Arrays;

/**
 * 快速排序
 *
 * @author 0xZzzz
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] array = {22, 11, 2, 34, 21, 54, 65, 87, 12, 55};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 快速排序
     */
    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        // 进行第一轮排序获取分割点
        int index = partition(array, left, right);
        // 排序前半部分
        quickSort(array, left, index - 1);
        // 排序后半部分
        quickSort(array, index + 1, right);
    }

    /**
     * 一次快速排序
     *
     * @param array 数组
     * @param left  数组的前下标
     * @param right 数组的后下标
     * @return key的下标index，也就是分片的间隔点
     */
    private static int partition(int[] array, int left, int right) {
        // 三数取中
        // 下面的两步保证了array[right]是最大的；
        int mid = left + (right - left) / 2;
        if (array[mid] > array[right]) {
            swap(array, mid, right);
        }
        if (array[left] > array[right]) {
            swap(array, left, right);
        }
        // 接下来只用比较array[left]和array[mid]，让较小的在array[left]位置就OK。
        if (array[mid] > array[left]) {
            swap(array, mid, left);
        }
        int key = array[left];
        while (left < right) {
            // 从后半部分向前扫描
            while (array[right] >= key && right > left) {
                right--;
            }
            array[left] = array[right];
            // 从前半部分向后扫描
            while (array[left] <= key && right > left) {
                left++;
            }
            array[right] = array[left];
        }
        // 最后把基准存入
        array[right] = key;
        return right;
    }

    /**
     * 交换
     */
    private static void swap(int[] arr, int e1, int e2) {
        int tmp = arr[e1];
        arr[e1] = arr[e2];
        arr[e2] = tmp;
    }

}
