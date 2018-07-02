package pattern.visitor;
/**
 * ����н�ʷ����߾���ʵ��
 */
public class SalaryVisitor implements ISalaryVisitor {
	//������н���ܺ�
	private float managerSalary;
	
	//��ͨԱ��н���ܺ�
	private float employeeSalary;
	
	//���췽����ʼ��н���ܺ;�Ϊ0
	public SalaryVisitor() {
		this.managerSalary = 0;
		this.employeeSalary = 0;
	}

	//���ʹ�����
	@Override
	public void visit(Manager manager) {
		managerSalary += manager.getSalary();
	}

	//������ͨԱ��
	@Override
	public void visit(Employee employee) {
		employeeSalary += employee.getSalary();
	}

	//ͳ�ƹ�����н���ܺ�
	@Override
	public void printManagerTotalSalary() {
		System.out.println("����Ա��н���ܺ�Ϊ: " + managerSalary);
	}

	//ͳ����ͨԱ��н���ܺ�
	@Override
	public void printEmployeeTotalSalary() {
		System.out.println("��ͨԱ����н���ܺ�Ϊ: " + employeeSalary);
	}

	//ͳ������Ա����н���ܺ�
	@Override
	public void printTotalSalary() {
		System.out.println("Ա��н���ܺ�Ϊ: " + (managerSalary + employeeSalary));
	}

}
