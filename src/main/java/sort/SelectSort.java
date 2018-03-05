package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] nums = {22, 11, 2, 34, 21, 54, 65, 87, 12, 55};
        int min;
        System.out.println("选择排序开始...");
        for (int i = 0; i < nums.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                    int temp = nums[i];
                    nums[i] = nums[min];
                    nums[min] = temp;
                    min = i; //每次找到一个新的最小值并交换位置后, 需要将最小值下标重置
                }
            }
        }
        System.out.println("选择排序结束...");
        System.out.print(Arrays.toString(nums));
    }
}
