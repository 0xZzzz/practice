package pattern.visitor;

/**
 * 访问者接口
 *
 * @author 0xZzzz
 */
public interface IVisitor {

    /**
     * 访问管理者
     *
     * @param manager 管理者
     */
    void visit(Manager manager);

    /**
     * 访问普通员工
     *
     * @param employee 普通员工
     */
    void visit(Employee employee);
}
