package sort;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author ZQ
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] nums = {22, 11, 2, 34, 21, 54, 65, 87, 12, 55};
        int in, out;
        System.out.println("插入排序开始...");
        for (out = 1; out < nums.length; out++) {
            int temp = nums[out];
            in = out;
            while (in > 0 && nums[in - 1] > temp) {
                nums[in] = nums[in - 1];
                --in;
            }
            nums[in] = temp;
        }
        System.out.println("插入排序结束...");
        System.out.print(Arrays.toString(nums));
    }
}
