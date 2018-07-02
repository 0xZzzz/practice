package pattern.chain;

/**
 * ��ʦ������
 */
public class TeacherHandler extends AbstractHandler {

    public TeacherHandler() {
        super(1);
    }

    @Override
    public void Process(IStudent iStudent) {
        System.out.println("��ʦ����: " + iStudent.getRequestMessage());
    }

}
