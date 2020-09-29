package pattern.visitor;

/**
 * 打印基本信息访问者
 *
 * @author 0xZzzz
 */
public class PrintBaseInfoVisitor implements IVisitor {

    @Override
    public void visit(Manager manager) {
        System.out.print("- 管理者: ");
        manager.printUserBaseInfo();
    }

    @Override
    public void visit(Employee employee) {
        System.out.print("- 一般员工: ");
        employee.printUserBaseInfo();
    }

}
