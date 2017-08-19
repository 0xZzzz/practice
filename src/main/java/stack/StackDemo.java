package stack;
/**
 * 实现栈结构
 * @author ZQ
 *
 */
public class StackDemo {
	private int top; //栈顶
	private int[] stackArr; //栈数组
	private int maxSize; //栈大小
	
	public StackDemo(int size){
		this.maxSize = size;
		stackArr = new int[maxSize];
		top = -1; //代表数组里还没有元素
	}
	
	public void push(int val){
		stackArr[++top] = val;
	}
	
	public int pop(){
		return stackArr[top--];
	}
	
	public int peek(){
		return stackArr[top];
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == maxSize - 1;
	}
	
	public static void main(String[] args) {
		StackDemo stack = new StackDemo(10);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.push(80);
		System.out.println(stack.peek());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		stack.push(90);
		System.out.println(stack.peek());
		
	}
}
