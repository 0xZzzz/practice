package pattern.visitor;

/**
 * ����н�ʷ����߾���ʵ��
 *
 * @author 0xZzzz
 */
public class SalaryVisitor implements ISalaryVisitor {

    /**
     * ������н���ܺ�
     */
    private float managerSalary;

    /**
     * ��ͨԱ��н���ܺ�
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
        System.out.println("����Ա��н���ܺ�Ϊ: " + managerSalary);
    }

    @Override
    public void printEmployeeTotalSalary() {
        System.out.println("��ͨԱ����н���ܺ�Ϊ: " + employeeSalary);
    }

    @Override
    public void printTotalSalary() {
        System.out.println("Ա��н���ܺ�Ϊ: " + (managerSalary + employeeSalary));
    }

}
