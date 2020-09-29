package pattern.visitor;

/**
 * ��ӡ������Ϣ������
 *
 * @author 0xZzzz
 */
public class PrintBaseInfoVisitor implements IVisitor {

    @Override
    public void visit(Manager manager) {
        System.out.print("- ������: ");
        manager.printUserBaseInfo();
    }

    @Override
    public void visit(Employee employee) {
        System.out.print("- һ��Ա��: ");
        employee.printUserBaseInfo();
    }

}
