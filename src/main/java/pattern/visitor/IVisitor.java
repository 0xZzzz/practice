package pattern.visitor;

/**
 * �����߽ӿ�
 */
public interface IVisitor {

    //���ʹ�����
    void visit(Manager manager);

    //������ͨԱ��
    void visit(Employee employee);
}
