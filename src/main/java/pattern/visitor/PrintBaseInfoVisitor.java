package pattern.visitor;

/**
 * ��ӡ������Ϣ������
 */
public class PrintBaseInfoVisitor implements IVisitor {

    //���ʹ����߶���
    @Override
    public void visit(Manager manager) {
        System.out.print("- ������: ");
        manager.printUserBaseInfo();
    }

    //������ͨԱ������
    @Override
    public void visit(Employee employee) {
        System.out.print("- һ��Ա��: ");
        employee.printUserBaseInfo();
    }

}
