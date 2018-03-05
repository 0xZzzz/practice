package thread.timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerDemo {

    private static int count = 0;

    public static void main(String[] args) {

        class MyTimerTask extends TimerTask {
            @Override
            public void run() {
                count = (count + 1) % 2; //0和1之间切换
                System.out.println("boom!");
                new Timer().schedule(new MyTimerTask(), 2000 + 2000 * count); //有点递归的意思
            }
        }

        new Timer().schedule(new MyTimerTask(), 2000);

        while (true) {
            System.out.println(new SimpleDateFormat("ss").format(new Date()));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
