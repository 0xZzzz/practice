package pattern.mediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * �н���ʵ����
 * @author 69953213
 *
 */
public class ConcreteMediator implements IMediator {
	//�洢���е�ע����û�
	private final List<IUser> list = new ArrayList<IUser>();
	
	//ʵ��ע�᷽��
	@Override
	public void register(IUser user) {
		if(user != null && !list.contains(user)){
			list.add(user);
		}
	}

	//�������˷�����Ϣ
	@Override
	public void notifyAll(IUser user) {
		Iterator<IUser> iterator = list.iterator();
		IUser tmpUser = null;
		while(iterator.hasNext()){
			tmpUser = iterator.next();
			if(tmpUser != null && !tmpUser.equals(user)){
				tmpUser.receiveMessage(user.getMessage());
			}
		}
	}

}
