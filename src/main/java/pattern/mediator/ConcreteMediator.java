package pattern.mediator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 中介者实现类
 *
 * @author 0xZzzz
 */
public class ConcreteMediator implements IMediator {

    //存储所有的注册的用户
    private final List<IUser> list = new ArrayList<IUser>();

    //实现注册方法
    @Override
    public void register(IUser user) {
        if (user != null && !list.contains(user)) {
            list.add(user);
        }
    }

    //给所有人发送消息
    @Override
    public void notifyAll(IUser user) {
        Iterator<IUser> iterator = list.iterator();
        IUser tmpUser = null;
        while (iterator.hasNext()) {
            tmpUser = iterator.next();
            if (tmpUser != null && !tmpUser.equals(user)) {
                tmpUser.receiveMessage(user.getMessage());
            }
        }
    }

}
