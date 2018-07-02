package pattern.visitor;

/**
 * 打印基本信息访问者
 */
public class PrintBaseInfoVisitor implements IVisitor {

    //访问管理者对象
    @Override
    public void visit(Manager manager) {
        System.out.print("- 管理者: ");
        manager.printUserBaseInfo();
    }

    //访问普通员工对象
    @Override
    public void visit(Employee employee) {
        System.out.print("- 一般员工: ");
        employee.printUserBaseInfo();
    }

}
