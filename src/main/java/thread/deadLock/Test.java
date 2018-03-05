package thread.deadLock;

public class Test {

    public static void main(String[] args) throws InterruptedException{
        DeadLockCar car2south = new DeadLockCar("S");
        DeadLockCar car2north = new DeadLockCar("N");
        DeadLockCar car2east = new DeadLockCar("E");
        DeadLockCar car2west = new DeadLockCar("W");

        car2south.start();
        car2north.start();
        car2east.start();
        car2west.start();
        //此时四车死锁
        Thread.sleep(1000);
        //强制剥夺任意车的资源, 解除死锁
        car2north.interrupt();
    }

}
