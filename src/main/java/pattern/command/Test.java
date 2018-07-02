package pattern.command;

public class Test {

    public static void main(String[] args) {
        IReceiver receiver = new Receiver();
        IPost post = new Post(receiver);
        Invoker invoker = new Invoker(post);
        invoker.sendMail("hello");
    }
}
