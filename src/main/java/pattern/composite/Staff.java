package pattern.composite;

/**
 * 员工基类
 *
 * @author 0xZzzz
 */
public abstract class Staff {

    /**
     * 员工编号
     */
    protected String no;

    /**
     * 员工姓名
     */
    protected String name;

    /**
     * 员工职位
     */
    protected String position;

    /**
     * 员工薪水
     */
    protected double salary;

    public Staff(String no, String name, String position, double salary) {
        this.no = no;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff [no=" + no + ", name=" + name + ", position=" + position
                + ", salary=" + salary + "]";
    }

    /**
     * 打印信息
     */
    public void printBasicInfo() {
        System.out.println(this.toString());
    }

    /**
     * 打印手下员工信息
     */
    public abstract void printEmployeesInfo();

}
