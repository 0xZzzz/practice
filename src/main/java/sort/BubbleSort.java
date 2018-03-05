package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {22, 11, 2, 34, 21, 54, 65, 87, 12, 55};
        System.out.println("冒泡排序开始...");
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序结束...");
        System.out.print(Arrays.toString(nums));
    }
}
