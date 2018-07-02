package pattern.chain;

/**
 * 教师处理者
 */
public class TeacherHandler extends AbstractHandler {

    public TeacherHandler() {
        super(1);
    }

    @Override
    public void Process(IStudent iStudent) {
        System.out.println("老师审批: " + iStudent.getRequestMessage());
    }

}
