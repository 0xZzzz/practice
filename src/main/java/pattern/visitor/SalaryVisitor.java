package pattern.visitor;
/**
 * 计算薪资访问者具体实现
 */
public class SalaryVisitor implements ISalaryVisitor {
	//管理者薪资总和
	private float managerSalary;
	
	//普通员工薪资总和
	private float employeeSalary;
	
	//构造方法初始化薪资总和均为0
	public SalaryVisitor() {
		this.managerSalary = 0;
		this.employeeSalary = 0;
	}

	//访问管理者
	@Override
	public void visit(Manager manager) {
		managerSalary += manager.getSalary();
	}

	//访问普通员工
	@Override
	public void visit(Employee employee) {
		employeeSalary += employee.getSalary();
	}

	//统计管理者薪资总和
	@Override
	public void printManagerTotalSalary() {
		System.out.println("管理员的薪资总和为: " + managerSalary);
	}

	//统计普通员工薪资总和
	@Override
	public void printEmployeeTotalSalary() {
		System.out.println("普通员工的薪资总和为: " + employeeSalary);
	}

	//统计所有员工的薪资总和
	@Override
	public void printTotalSalary() {
		System.out.println("员工薪资总和为: " + (managerSalary + employeeSalary));
	}

}
