package binarySearch;

import java.util.Arrays;

/**
 * 二分查找算法
 *
 * @author ZQ
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {12, 87, 33, 32, 76, 43, 55};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int index = binarySearch(arr, 43);
        System.out.println(index);
    }

    public static int binarySearch(int[] arr, int n) {
        int start = 0;//起始位置
        int end = arr.length - 1;//结束位置
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                start = mid + 1;
            } else if (arr[mid] > n) {
                end = mid - 1;
            }
        }
        return -1;
    }
}
