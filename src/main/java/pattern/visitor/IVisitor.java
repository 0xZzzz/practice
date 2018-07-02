package pattern.visitor;

/**
 * 访问者接口
 */
public interface IVisitor {

    //访问管理者
    void visit(Manager manager);

    //访问普通员工
    void visit(Employee employee);
}
