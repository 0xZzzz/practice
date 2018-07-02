package pattern.visitor;

/**
 * ����Ա����
 */
public abstract class Staff {

    //Ա����
    protected String no;

    //Ա������
    protected String name;

    //Ա��ְλ
    protected String position;

    //нˮ
    protected float salary;

    //˽������ �����ַ���
    private int length;

    //���췽����ʼ������
    public Staff(String no, String name, String position, float salary) {
        this.no = no;
        this.name = name;
        this.position = position;
        this.salary = salary;
        //�������ֽڳ���
        this.length += (no == null || "".equals(no.trim())) ? 0 : no.getBytes().length;
        this.length += (name == null || "".equals(name.trim())) ? 0 : name.getBytes().length;
        this.length += (position == null || "".equals(position.trim())) ? 0 : position.getBytes().length;
        this.length += String.valueOf(salary).getBytes().length;

    }

    //����û��Ļ�����Ϣ
    public void printUserBaseInfo() {
        System.out.println("-|" + this.no + " " + this.name + " " + this.position + " " + this.salary);
    }

    //���Ա����Ϣ
    public abstract void add(Staff staff);

    //����Ա����ɾ��Ա��
    public abstract Staff remove(String no);

    //���ܷ����߶���
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
