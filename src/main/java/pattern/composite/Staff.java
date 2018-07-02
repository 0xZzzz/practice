package pattern.composite;

/**
 * Ա������
 *
 * @author 0xZzzz
 */
public abstract class Staff {

    /**
     * Ա�����
     */
    protected String no;

    /**
     * Ա������
     */
    protected String name;

    /**
     * Ա��ְλ
     */
    protected String position;

    /**
     * Ա��нˮ
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
     * ��ӡ��Ϣ
     */
    public void printBasicInfo() {
        System.out.println(this.toString());
    }

    /**
     * ��ӡ����Ա����Ϣ
     */
    public abstract void printEmployeesInfo();

}
