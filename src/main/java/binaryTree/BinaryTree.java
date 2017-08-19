package binaryTree;

/**
 * ������ʵ��
 * 
 * @author ZQ
 * 
 */
public class BinaryTree {

	private Node root; // ���ڵ�

	public void add(int data) {
		if (this.root == null) {
			root = new Node(data);
		} else {
			root.addNode(data);
		}
	}

	public void print() {
		if (root != null) {
			root.printNode();
		} else {
			System.out.println("���ǿյ�");
		}
	}

	class Node {
		private int data; // ��ǰ�ڵ�����
		private Node left; // ������
		private Node right; // ������

		public Node(int data) {
			this.data = data;
		}

		/**
		 * ��ӽڵ�
		 * 
		 * @param data
		 *            Ҫ��ӵ�����
		 */
		public void addNode(int data) {
			if (this.data > data) { // ������������������Ӧ���ڵ�ǰ�ڵ����
				if (this.left == null) { // �����ǰ�ڵ�������Ϊ��, �򴴽�������Ϊ��ǰ�ڵ��������
					this.left = new Node(data);
				} else {
					this.left.addNode(data); // �����ǰ�ڵ����������Ϊ��,
												// ������жϸ������뵱ǰ�ڵ����������ݵĹ�ϵ
				}
			} else if (this.data <= data) { // ������������������Ӧ���ڵ�ǰ�ڵ���Ҳ�
				if (this.right == null) { // �����ǰ�ڵ��������Ϊ��, �򴴽�������Ϊ��ǰ�ڵ��������
					this.right = new Node(data);
				} else {
					this.right.addNode(data); // �����ǰ�ڵ����������Ϊ��,
												// ������жϸ������뵱ǰ�ڵ��������Ĺ�ϵ
				}
			}
		}

		/**
		 * �������(������)
		 */
		public void printNode() {
			if (this.left != null) {
				this.left.printNode();
			}
			System.out.print(this.data + " ");
			if (this.right != null) {
				this.right.printNode();
			}
		}
	}
}
