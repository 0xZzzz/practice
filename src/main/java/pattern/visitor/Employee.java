package pattern.visitor;

/**
 * 普通员工
 */
public class Employee extends Staff {

    public Employee(String no, String name, String position, float salary) {
        super(no, name, position, salary);
    }

    //普通员工不能添加员工 , 空实现
    @Override
    public void add(Staff staff) {
        return;
    }

    //普通员工不能删除员工, 返回空
    @Override
    public Staff remove(String no) {
        return null;
    }

    //接受访问者对象
    @Override
    public void accept(IVisitor visitor) {
        //访问自己
        visitor.visit(this);
    }

}
