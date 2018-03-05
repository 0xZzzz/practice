package thread.deadLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 模拟死锁场景, 向四个方向行驶的车
 */
public class DeadLockCar extends Thread {
    private String myDirect;
    private static ReentrantLock eastLock = new ReentrantLock();
    private static ReentrantLock westLock = new ReentrantLock();
    private static ReentrantLock southLock = new ReentrantLock();
    private static ReentrantLock northLock = new ReentrantLock();

    public DeadLockCar(String direct) {
        this.myDirect = direct;
        //设置线程的名称
        if ("S".equals(myDirect)) {
            this.setName("south");
        }
        if ("N".equals(myDirect)) {
            this.setName("north");
        }
        if ("E".equals(myDirect)) {
            this.setName("east");
        }
        if ("W".equals(myDirect)) {
            this.setName("west");
        }
    }

    @Override
    public void run() {
        //向南走的车占据了向西的路
        if ("S".equals(myDirect)) {
            try {
                westLock.lockInterruptibly();
                Thread.sleep(500);
                southLock.lockInterruptibly(); // 等待向南的路
                System.out.println("car to south has passed");
            } catch (InterruptedException e) {
                System.out.println("car to south is killed");
            } finally {
                //查看当前线程是否持有该锁  如果有 则释放
                if (westLock.isHeldByCurrentThread()) {
                    westLock.unlock();
                }
                if (southLock.isHeldByCurrentThread()) {
                    southLock.unlock();
                }
            }
        }
        //向北走的车占据的向东的路
        if ("N".equals(myDirect)) {
            try {
                eastLock.lockInterruptibly();
                Thread.sleep(500);
                northLock.lockInterruptibly(); //等待着向北走的路
                System.out.println("car to north has passed");
            } catch (InterruptedException e) {
                System.out.println("car to north is killed");
            } finally {
                if (northLock.isHeldByCurrentThread()) {
                    northLock.unlock();
                }
                if (eastLock.isHeldByCurrentThread()) {
                    eastLock.unlock();
                }
            }
        }
        //向东走的车占据了向南的路
        if ("E".equals(myDirect)) {
            try {
                southLock.lockInterruptibly();
                Thread.sleep(500);
                eastLock.lockInterruptibly(); //等待着向东走的路
                System.out.println("car to east has passed");
            } catch (InterruptedException e) {
                System.out.println("car to east is killed");
            } finally {
                if (eastLock.isHeldByCurrentThread()) {
                    eastLock.unlock();
                }
                if (southLock.isHeldByCurrentThread()) {
                    southLock.unlock();
                }
            }
        }
        //向西走的车占据了向北的路
        if ("W".equals(myDirect)) {
            try {
                northLock.lockInterruptibly();
                Thread.sleep(500);
                westLock.lockInterruptibly(); //等待着向西走的路
                System.out.println("car to west has passed");
            } catch (InterruptedException e) {
                System.out.println("car to west is killed");
            } finally {
                if (westLock.isHeldByCurrentThread()) {
                    westLock.unlock();
                }
                if (northLock.isHeldByCurrentThread()) {
                    northLock.unlock();
                }
            }
        }
    }
}
