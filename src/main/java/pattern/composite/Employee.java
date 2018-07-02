package pattern.composite;

public class Employee extends Staff {

    public Employee(String no, String name, String position, double salary) {
        super(no, name, position, salary);
    }

    @Override
    public void printEmployeesInfo() {
        return;
    }

}
