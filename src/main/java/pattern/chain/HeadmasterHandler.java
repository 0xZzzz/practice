package pattern.chain;

/**
 * 校长处理者
 */
public class HeadmasterHandler extends AbstractHandler {

    public HeadmasterHandler() {
        super(2);
    }

    @Override
    public void Process(IStudent iStudent) {
        System.out.println("校长审批: " + iStudent.getRequestMessage());
    }

}
