package pattern.chain;

/**
 * У��������
 */
public class HeadmasterHandler extends AbstractHandler {

    public HeadmasterHandler() {
        super(2);
    }

    @Override
    public void Process(IStudent iStudent) {
        System.out.println("У������: " + iStudent.getRequestMessage());
    }

}
