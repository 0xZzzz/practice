package pattern.visitor;

/**
 * 计算薪资访问者具体实现
 *
 * @author 0xZzzz
 */
public class SalaryVisitor implements ISalaryVisitor {

    /**
     * 管理者薪资总和
     */
    private float managerSalary;

    /**
     * 普通员工薪资总和
     */
    private float employeeSalary;

    public SalaryVisitor() {
        this.managerSalary = 0;
        this.employeeSalary = 0;
    }

    @Override
    public void visit(Manager manager) {
        managerSalary += manager.getSalary();
    }

    @Override
    public void visit(Employee employee) {
        employeeSalary += employee.getSalary();
    }

    @Override
    public void printManagerTotalSalary() {
        System.out.println("管理员的薪资总和为: " + managerSalary);
    }

    @Override
    public void printEmployeeTotalSalary() {
        System.out.println("普通员工的薪资总和为: " + employeeSalary);
    }

    @Override
    public void printTotalSalary() {
        System.out.println("员工薪资总和为: " + (managerSalary + employeeSalary));
    }

}
