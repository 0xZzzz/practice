package binaryTree;

/**
 * 二叉树实现
 *
 * @author ZQ
 */
public class BinaryTree {

    private Node root; // 根节点

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
            System.out.println("树是空的");
        }
    }

    class Node {
        private int data; // 当前节点数据
        private Node left; // 左子树
        private Node right; // 右子树

        public Node(int data) {
            this.data = data;
        }

        /**
         * 添加节点
         *
         * @param data 要添加的数据
         */
        public void addNode(int data) {
            if (this.data > data) { // 满足条件则代表该数据应放在当前节点左侧
                if (this.left == null) { // 如果当前节点左子树为空, 则创建该数据为当前节点的左子树
                    this.left = new Node(data);
                } else {
                    this.left.addNode(data); // 如果当前节点的左子树不为空,
                    // 则继续判断该数据与当前节点左子树数据的关系
                }
            } else if (this.data <= data) { // 满足条件则代表该数据应放在当前节点的右侧
                if (this.right == null) { // 如果当前节点的右子树为空, 则创建该数据为当前节点的右子树
                    this.right = new Node(data);
                } else {
                    this.right.addNode(data); // 如果当前节点的右子树不为空,
                    // 则继续判断该数据与当前节点右子树的关系
                }
            }
        }

        /**
         * 中序遍历(左中右)
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
