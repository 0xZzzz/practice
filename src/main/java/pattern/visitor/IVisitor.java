package pattern.visitor;

/**
 * �����߽ӿ�
 *
 * @author 0xZzzz
 */
public interface IVisitor {

    /**
     * ���ʹ�����
     *
     * @param manager ������
     */
    void visit(Manager manager);

    /**
     * ������ͨԱ��
     *
     * @param employee ��ͨԱ��
     */
    void visit(Employee employee);
}
