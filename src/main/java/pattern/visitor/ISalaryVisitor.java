package pattern.visitor;

/**
 * ����н�ʷ�����
 */
public interface ISalaryVisitor extends IVisitor {

    //ͳ�ƹ�����н�����
    void printManagerTotalSalary();

    //ͳ��һ��Ա��н�����
    void printEmployeeTotalSalary();

    //ͳ������Ա��н�����
    void printTotalSalary();

}
