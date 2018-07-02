package pattern.composite;

public class Test {

    public static void main(String[] args) {
        Manager ceo = new Manager("01", "首席执行官", "CEO", 0);
        Manager cto = new Manager("02", "首席技术官", "CTO", 0);
        Manager tManager = new Manager("02001", "技术经理", "技术经理", 30000);
        Employee emp = new Employee("02001001", "程序猿", "程序猿", 10000);
        cto.add(tManager);
        ceo.add(cto);
        tManager.add(emp);
        cto.printEmployeesInfo();
    }
}
