package pattern.chain;

public class Test {

    public static void main(String[] args) {

        IStudent student = new Student(1, "����");
        ProcessHandler processHandler = ProcessHandler.getInstance();
        processHandler.sendMessage(student);

        System.out.println((double) 1 / 100);
    }
}
