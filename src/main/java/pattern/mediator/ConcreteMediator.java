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

    private final List<IUser> list = new ArrayList<>();

    @Override
    public void register(IUser user) {
        if (user != null && !list.contains(user)) {
            list.add(user);
        }
    }

    @Override
    public void notifyAll(IUser user) {
        Iterator<IUser> iterator = list.iterator();
        IUser tmpUser;
        while (iterator.hasNext()) {
            tmpUser = iterator.next();
            if (tmpUser != null && !tmpUser.equals(user)) {
                tmpUser.receiveMessage(user.getMessage());
            }
        }
    }

}
