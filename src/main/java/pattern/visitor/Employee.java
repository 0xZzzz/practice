package pattern.visitor;

/**
 * ��ͨԱ��
 */
public class Employee extends Staff {

    public Employee(String no, String name, String position, float salary) {
        super(no, name, position, salary);
    }

    //��ͨԱ���������Ա�� , ��ʵ��
    @Override
    public void add(Staff staff) {
        return;
    }

    //��ͨԱ������ɾ��Ա��, ���ؿ�
    @Override
    public Staff remove(String no) {
        return null;
    }

    //���ܷ����߶���
    @Override
    public void accept(IVisitor visitor) {
        //�����Լ�
        visitor.visit(this);
    }

}
