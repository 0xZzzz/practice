package pattern.state;

/**
 * �༭ģʽ״̬
 */
public class EditState implements IState {

    //״̬ת��
    @Override
    public void convertState(Context context, int mode) {
        if (mode == Context.PREVIEW_MODE) {
            context.changeState(new PreviewState());
        }
    }

    //�༭ģʽ����
    @Override
    public void save(Context context) {
        System.out.println("�༭ģʽ[����]...");
    }

    //�༭ģʽ�޸�
    @Override
    public void modify(Context context) {
        System.out.println("�༭ģʽ[�޸�]...");
    }

    //�༭ģʽ����
    @Override
    public void add(Context context) {
        System.out.println("�༭ģʽ[����]...");
    }

    //�༭ģʽ�鿴
    @Override
    public void view(Context context) {
        System.out.println("�༭ģʽ[�鿴]...");
    }

}
