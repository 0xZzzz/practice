package sort;

import java.util.Arrays;

/**
 * ѡ������ 
 * @author ZQ
 *
 */
public class SelectSort {
	public static void main(String[] args) {
		int[] nums = {22,11,2,34,21,54,65,87,12,55};
		int min;
		System.out.println("ѡ������ʼ...");
		for (int i = 0; i < nums.length-1; i++) {
			min = i;
			for (int j = i+1; j < nums.length; j++) {
				if(nums[j] < nums[min]){
					min = j;
					int temp = nums[i];
					nums[i] = nums[min];
					nums[min] = temp;
					min = i; //ÿ���ҵ�һ���µ���Сֵ������λ�ú�, ��Ҫ����Сֵ�±�����
				}
			}
		}
		System.out.println("ѡ���������...");
		System.out.print(Arrays.toString(nums));
	}
}
