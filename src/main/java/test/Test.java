package test;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(Test.add(5));
	}
	
	/**
	 * �ݹ����
	 * @param num ����
	 * @return 1~num������֮��
	 */
	public static int add(int num){
		if(num <= 1){
			return num;
		}
		return num + add(num-1);
	}
}
