package pattern.visitor;

/**
 * 抽象员工类
 */
public abstract class Staff {

    //员工号
    protected String no;

    //员工姓名
    protected String name;

    //员工职位
    protected String position;

    //薪水
    protected float salary;

    //私有属性 长度字符串
    private int length;

    //构造方法初始化属性
    public Staff(String no, String name, String position, float salary) {
        this.no = no;
        this.name = name;
        this.position = position;
        this.salary = salary;
        //计算总字节长度
        this.length += (no == null || "".equals(no.trim())) ? 0 : no.getBytes().length;
        this.length += (name == null || "".equals(name.trim())) ? 0 : name.getBytes().length;
        this.length += (position == null || "".equals(position.trim())) ? 0 : position.getBytes().length;
        this.length += String.valueOf(salary).getBytes().length;

    }

    //获得用户的基本信息
    public void printUserBaseInfo() {
        System.out.println("-|" + this.no + " " + this.name + " " + this.position + " " + this.salary);
    }

    //添加员工信息
    public abstract void add(Staff staff);

    //根据员工号删除员工
    public abstract Staff remove(String no);

    //接受访问者对象
    public abstract void accept(IVisitor visitor);

    // getter and setter start ...
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

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }
    //getter and setter end ...

}
