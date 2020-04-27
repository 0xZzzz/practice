package pattern.mediator;

public class Test {

    public static void main(String[] args) {
        IMediator mediator = new ConcreteMediator();

        IUser userA = new UserA(mediator, "用户A");
        IUser userB = new UserB(mediator, "用户B");
        IUser userC = new UserC(mediator, "用户C");

        userA.sendMessage("天王盖地虎");
        userB.sendMessage("宝塔镇河妖");
        userC.sendMessage("...");

    }
}
