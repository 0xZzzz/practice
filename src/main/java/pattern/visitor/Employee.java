package pattern.visitor;

/**
 * 普通员工
 *
 * @author 0xZzzz
 */
public class Employee extends Staff {

    public Employee(String no, String name, String position, float salary) {
        super(no, name, position, salary);
    }

    @Override
    public void add(Staff staff) {
        // 普通员工不能添加员工 , 空实现
    }

    @Override
    public Staff remove(String no) {
        // 普通员工不能删除员工, 返回空
        return null;
    }

    @Override
    public void accept(IVisitor visitor) {
        // 接受访问者对象
        // 访问自己
        visitor.visit(this);
    }

}
