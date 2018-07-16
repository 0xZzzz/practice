package test;

public class Test {
	
	public static void main(String[] args) {
		System.out.println(Test.add(5));
	}
	
	/**
	 * 递归求和
	 */
	public static int add(int num){
		if(num <= 1){
			return num;
		}
		return num + add(num-1);
	}
}
