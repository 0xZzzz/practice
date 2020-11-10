package pattern.mediator;

public class MediatorTest {

    public static void main(String[] args) {
        IMediator mediator = new ConcreteMediator();

        IUser userA = new UserA(mediator, "userA");
        IUser userB = new UserB(mediator, "userB");
        IUser userC = new UserC(mediator, "userC");

        userA.sendMessage("tian wang gai di hu");
        userB.sendMessage("bao ta zhen he yao");
        userC.sendMessage("...");

    }
}
