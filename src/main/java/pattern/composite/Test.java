package pattern.composite;

public class Test {

    public static void main(String[] args) {
        Manager ceo = new Manager("01", "��ϯִ�й�", "CEO", 0);
        Manager cto = new Manager("02", "��ϯ������", "CTO", 0);
        Manager tManager = new Manager("02001", "��������", "��������", 30000);
        Employee emp = new Employee("02001001", "����Գ", "����Գ", 10000);
        cto.add(tManager);
        ceo.add(cto);
        tManager.add(emp);
        cto.printEmployeesInfo();
    }
}