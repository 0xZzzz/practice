package pattern.visitor;

/**
 * 计算薪资访问者
 */
public interface ISalaryVisitor extends IVisitor {

    //统计管理者薪资情况
    void printManagerTotalSalary();

    //统计一般员工薪资情况
    void printEmployeeTotalSalary();

    //统计所有员工薪资情况
    void printTotalSalary();

}
